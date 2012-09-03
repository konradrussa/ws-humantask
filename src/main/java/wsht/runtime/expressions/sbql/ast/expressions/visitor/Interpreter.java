package wsht.runtime.expressions.sbql.ast.expressions.visitor;

import java.util.List;

import wsht.runtime.expressions.sbql.ast.expressions.DotExpression;
import wsht.runtime.expressions.sbql.ast.expressions.NameExpression;
import wsht.runtime.expressions.sbql.ast.expressions.WhereExpression;
import wsht.runtime.expressions.sbql.ast.operators.AllOperator;
import wsht.runtime.expressions.sbql.ast.operators.AndOperator;
import wsht.runtime.expressions.sbql.ast.operators.AnyOperator;
import wsht.runtime.expressions.sbql.ast.operators.AsOperator;
import wsht.runtime.expressions.sbql.ast.operators.AvgOperator;
import wsht.runtime.expressions.sbql.ast.operators.BagConstructor;
import wsht.runtime.expressions.sbql.ast.operators.CommaOperator;
import wsht.runtime.expressions.sbql.ast.operators.CountOperator;
import wsht.runtime.expressions.sbql.ast.operators.DivideBinaryOperator;
import wsht.runtime.expressions.sbql.ast.operators.EqualsOperator;
import wsht.runtime.expressions.sbql.ast.operators.GreaterEqualsOperator;
import wsht.runtime.expressions.sbql.ast.operators.GreaterOperator;
import wsht.runtime.expressions.sbql.ast.operators.GroupAsOperator;
import wsht.runtime.expressions.sbql.ast.operators.IntersectOperator;
import wsht.runtime.expressions.sbql.ast.operators.LessEqualsOperator;
import wsht.runtime.expressions.sbql.ast.operators.LessOperator;
import wsht.runtime.expressions.sbql.ast.operators.MaxOperator;
import wsht.runtime.expressions.sbql.ast.operators.MinOperator;
import wsht.runtime.expressions.sbql.ast.operators.MinusBinaryOperator;
import wsht.runtime.expressions.sbql.ast.operators.MinusOperator;
import wsht.runtime.expressions.sbql.ast.operators.MinusUnaryOperator;
import wsht.runtime.expressions.sbql.ast.operators.ModBinaryOperator;
import wsht.runtime.expressions.sbql.ast.operators.MultiplyBinaryOperator;
import wsht.runtime.expressions.sbql.ast.operators.NotEqualsOperator;
import wsht.runtime.expressions.sbql.ast.operators.OrOperator;
import wsht.runtime.expressions.sbql.ast.operators.PlusBinaryOperator;
import wsht.runtime.expressions.sbql.ast.operators.PlusUnaryOperator;
import wsht.runtime.expressions.sbql.ast.operators.StructConstructor;
import wsht.runtime.expressions.sbql.ast.operators.SumOperator;
import wsht.runtime.expressions.sbql.ast.operators.UnionOperator;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ConcatWithDelimiterFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ConcatFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ExceptFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.MostFrequentOccurenceFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.GetActualOwnerFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.GetBusinessAdministratorsFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.GetCountOfFinishedSubTasksFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.GetCountOfSubTasksFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.GetCountOfSubTasksInStateFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.GetCountOfSubTasksWithOutcomeFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.GetExcludedOwnersFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.GetInputFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.GetLogicalPeopleGroupFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.GetOutcomeFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.GetOutputFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.GetPotentialOwnersFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.GetSubtaskOutputFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.GetSubtaskOutputsFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.GetTaskInitiatorFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.GetTaskPriorityFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.GetTaskStakeholdersFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.LeastFrequentOccurenceFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.VoteFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.VoteOnStringFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.WaitForFunction;
import wsht.runtime.expressions.sbql.ast.operators.wsht.WaitUntilFunction;
import wsht.runtime.expressions.sbql.ast.terminals.BooleanTerminal;
import wsht.runtime.expressions.sbql.ast.terminals.DoubleTerminal;
import wsht.runtime.expressions.sbql.ast.terminals.IdentTerminal;
import wsht.runtime.expressions.sbql.ast.terminals.IntegerTerminal;
import wsht.runtime.expressions.sbql.ast.terminals.StringTerminal;
import wsht.runtime.expressions.sbql.envs.ENVS;
import wsht.runtime.expressions.sbql.envs.ENVSBinder;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BagResult;
import wsht.runtime.expressions.sbql.qres.result.BooleanResult;
import wsht.runtime.expressions.sbql.qres.result.IntegerResult;
import wsht.runtime.expressions.sbql.qres.result.RealResult;
import wsht.runtime.expressions.sbql.qres.result.StringResult;
import wsht.runtime.expressions.sbql.qres.result.StructResult;
import wsht.runtime.expressions.sbql.util.Util;

public class Interpreter implements ASTVisitor {
	


	public void visitDotExpression(DotExpression expression) {
		BagResult eres = new BagResult();
		expression.getLeftExpression().accept(this);
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof BagResult) {
			for(AbstractQueryResult r : ((BagResult)res).getElements()) {
				List<ENVSBinder> binders = ENVS.getInstance().nested(r);
				expression.getRightExpression().accept(this);
				if(binders.size() > 0)
					ENVS.getInstance().pop();
				eres.add(QRES.getInstance().pop(false));
			}
		} else if(res instanceof StructResult) {
			for(AbstractQueryResult r : ((StructResult)res).getAtoms()) {
				List<ENVSBinder> binders = ENVS.getInstance().nested(r);
				expression.getRightExpression().accept(this);
				if(binders.size() > 0)
					ENVS.getInstance().pop();
				eres.add(QRES.getInstance().pop(false));
			}
		} else {
			List<ENVSBinder> binders = ENVS.getInstance().nested(res);
			expression.getRightExpression().accept(this);
			//if(binders.size() > 0)
				ENVS.getInstance().pop();
			eres.add(QRES.getInstance().pop(false));
		}

		QRES.getInstance().push(eres);
	}

	public void visitWhereExpression(WhereExpression expression) {
		BagResult eres = new BagResult();
		expression.getLeftExpression().accept(this);
		AbstractQueryResult res = QRES.getInstance().pop(false);
		for(AbstractQueryResult r : ((BagResult)res).getElements()) {
			List<ENVSBinder> binders = ENVS.getInstance().nested(r);
			expression.getRightExpression().accept(this);
			AbstractQueryResult wres = QRES.getInstance().pop(false);
			AbstractQueryResult trueRes = Util.deref(wres);
			if(trueRes instanceof BooleanResult && ((BooleanResult)trueRes).isValue()) {
				eres.add(r);
			}
			if(binders.size() > 0)
				ENVS.getInstance().pop();
		}
		QRES.getInstance().push(eres);
	}
	
	public void visitNameExpression(NameExpression expression) {
		if(expression.getInnerExpression() instanceof IdentTerminal) {
			BagResult res = ENVS.getInstance().bind(expression.getName());
			QRES.getInstance().push(res);
		} else {
			throw new SBQLEvalException("Interpreter.visitNameExpression nie jest IdentTerminal w bind");
		}

	}

	public void visitStringTerminal(StringTerminal stringTerminal) {
		StringResult result = new StringResult(stringTerminal.getValue());
		QRES.getInstance().push(result);
	}
	
	public void visitIdentTerminal(IdentTerminal identTerminal) {
		StringResult result = new StringResult(identTerminal.getValue());
		QRES.getInstance().push(result);
	}

	public void visitBooleanTerminal(BooleanTerminal booleanTerminal) {
		BooleanResult result = new BooleanResult(booleanTerminal.getValue());
		QRES.getInstance().push(result);
	}

	public void visitDoubleTerminal(DoubleTerminal doubleTerminal) {
		RealResult result = new RealResult(doubleTerminal.getValue());
		QRES.getInstance().push(result);
	}

	public void visitIntegerTerminal(IntegerTerminal integerTerminal) {
		IntegerResult result = new IntegerResult(integerTerminal.getValue());
		QRES.getInstance().push(result);
	}
	
	public void visitEqualsExpression(EqualsOperator equalsOperator) {
		equalsOperator.getLeftExpression().accept(this);
		equalsOperator.getRightExpression().accept(this);
		equalsOperator.eval();
	}
	
	public void visitMinusBinaryExpression(MinusBinaryOperator minusBinaryOperator) {
		minusBinaryOperator.getLeftExpression().accept(this);
		minusBinaryOperator.getRightExpression().accept(this);
		minusBinaryOperator.eval();
	}
	
	public void visitPlusBinaryExpression(PlusBinaryOperator plusBinaryOperator) {
		plusBinaryOperator.getLeftExpression().accept(this);
		plusBinaryOperator.getRightExpression().accept(this);
		plusBinaryOperator.eval();
	}


	public void visitMultiplyBinaryExpression(MultiplyBinaryOperator multiplyBinaryOperator) {
		multiplyBinaryOperator.getLeftExpression().accept(this);
		multiplyBinaryOperator.getRightExpression().accept(this);
		multiplyBinaryOperator.eval();
	}

	public void visitDivideBinaryExpression(DivideBinaryOperator divideBinaryOperator) {
		divideBinaryOperator.getLeftExpression().accept(this);
		divideBinaryOperator.getRightExpression().accept(this);
		divideBinaryOperator.eval();
	}
	
	public void visitModBinaryExpression(ModBinaryOperator modBinaryOperator) {
		modBinaryOperator.getLeftExpression().accept(this);
		modBinaryOperator.getRightExpression().accept(this);
		modBinaryOperator.eval();
	}

	public void visitNotEqualsExpression(NotEqualsOperator notEqualsOperator) {
		notEqualsOperator.getLeftExpression().accept(this);
		notEqualsOperator.getRightExpression().accept(this);
		notEqualsOperator.eval();
	}

	public void visitGreaterExpression(GreaterOperator greaterOperator) {
		greaterOperator.getLeftExpression().accept(this);
		greaterOperator.getRightExpression().accept(this);
		greaterOperator.eval();
	}

	public void visitLessEqualsExpression(LessEqualsOperator lessEqualsOperator) {
		lessEqualsOperator.getLeftExpression().accept(this);
		lessEqualsOperator.getRightExpression().accept(this);
		lessEqualsOperator.eval();
	}

	public void visitLessExpression(LessOperator lessOperator) {
		lessOperator.getLeftExpression().accept(this);
		lessOperator.getRightExpression().accept(this);
		lessOperator.eval();
	}

	public void visitGreaterEqualsExpression(GreaterEqualsOperator greaterEqualsOperator) {
		greaterEqualsOperator.getLeftExpression().accept(this);
		greaterEqualsOperator.getRightExpression().accept(this);
		greaterEqualsOperator.eval();
	}

	public void visitAndExpression(AndOperator andOperator) {
		andOperator.getLeftExpression().accept(this);
		andOperator.getRightExpression().accept(this);
		andOperator.eval();
	}

	public void visitOrExpression(OrOperator orOperator) {
		orOperator.getLeftExpression().accept(this);
		orOperator.getRightExpression().accept(this);
		orOperator.eval();
	}

	public void visitAsExpression(AsOperator asOperator) {
		asOperator.getInnerExpression().accept(this);
		asOperator.eval();
	}

	public void visitGroupAsExpression(GroupAsOperator groupAsOperator) {
		groupAsOperator.getInnerExpression().accept(this);
		groupAsOperator.eval();
	}

	public void visitCommaExpression(CommaOperator commaOperator) {
		commaOperator.getLeftExpression().accept(this);
		commaOperator.getRightExpression().accept(this);
		commaOperator.eval();
	}

	public void visitUnionExpression(UnionOperator unionOperator) {
		unionOperator.getLeftExpression().accept(this);
		unionOperator.getRightExpression().accept(this);
		unionOperator.eval();
	}

	public void visitBagExpression(BagConstructor bagConstructor) {
		bagConstructor.getInnerExpression().accept(this);
		bagConstructor.eval();
	}

	public void visitStructExpression(StructConstructor structConstructor) {
		structConstructor.getInnerExpression().accept(this);
		structConstructor.eval();
	}

	public void visitAllExpression(AllOperator allOperator) {
		allOperator.getLeftExpression().accept(this);
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof BagResult) {
			for(AbstractQueryResult r : ((BagResult)res).getElements()) {
				List<ENVSBinder> binders = ENVS.getInstance().nested(r);
				allOperator.getRightExpression().accept(this);
				if(binders.size() > 0)
					ENVS.getInstance().pop();
				AbstractQueryResult rightRes = QRES.getInstance().pop(false);
				
				if(rightRes instanceof BagResult && ((BagResult) rightRes).getElements().size() > 1) {
					throw new SBQLEvalException("AllOperator.visit - rezultat nie jest pojedynczym elementem");
				} else {
					rightRes = Util.deref(rightRes);
				}
				
				if(rightRes instanceof BooleanResult && !((BooleanResult) rightRes).isValue()) {
					QRES.getInstance().push(rightRes);
					return;
				} 
			}
		} else if(res instanceof StructResult) {
			for(AbstractQueryResult r : ((StructResult)res).getAtoms()) {
				List<ENVSBinder> binders = ENVS.getInstance().nested(r);
				allOperator.getRightExpression().accept(this);
				if(binders.size() > 0)
					ENVS.getInstance().pop();
				AbstractQueryResult rightRes = QRES.getInstance().pop(false);
				
				if(rightRes instanceof BagResult && ((BagResult) rightRes).getElements().size() > 1) {
					throw new SBQLEvalException("AllOperator.visit - rezultat nie jest pojedynczym elementem");
				} else {
					rightRes = Util.deref(rightRes);
				}
				
				if(rightRes instanceof BooleanResult && !((BooleanResult) rightRes).isValue()) {
					QRES.getInstance().push(rightRes);
					return;
				} 
			}
		} else {
			List<ENVSBinder> binders = ENVS.getInstance().nested(res);
			allOperator.getRightExpression().accept(this);
			//if(binders.size() > 0)
				ENVS.getInstance().pop();
			AbstractQueryResult rightRes = QRES.getInstance().pop(false);
			
			if(rightRes instanceof BagResult && ((BagResult) rightRes).getElements().size() > 1) {
				throw new SBQLEvalException("AllOperator.visit - rezultat nie jest pojedynczym elementem");
			} else {
				rightRes = Util.deref(rightRes);
			}
			
			if(rightRes instanceof BooleanResult && !((BooleanResult) rightRes).isValue()) {
				QRES.getInstance().push(rightRes);
				return;
			} 
		}
		QRES.getInstance().push(new BooleanResult(true));
	}

	public void visitAnyExpression(AnyOperator anyOperator) {
		anyOperator.getLeftExpression().accept(this);
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof BagResult) {
			for(AbstractQueryResult r : ((BagResult)res).getElements()) {
				List<ENVSBinder> binders = ENVS.getInstance().nested(r);
				anyOperator.getRightExpression().accept(this);
				if(binders.size() > 0)
					ENVS.getInstance().pop();
				AbstractQueryResult rightRes = QRES.getInstance().pop(false);
				
				if(rightRes instanceof BagResult && ((BagResult) rightRes).getElements().size() > 1) {
					throw new SBQLEvalException("AnyOperator.visit - rezultat nie jest pojedynczym elementem");
				} else {
					rightRes = Util.deref(rightRes);
				}
				
				if(rightRes instanceof BooleanResult && ((BooleanResult) rightRes).isValue()) {
					QRES.getInstance().push(rightRes);
					return;
				}
			}
		} else if(res instanceof StructResult) {
			for(AbstractQueryResult r : ((StructResult)res).getAtoms()) {
				List<ENVSBinder> binders = ENVS.getInstance().nested(r);
				anyOperator.getRightExpression().accept(this);
				if(binders.size() > 0)
					ENVS.getInstance().pop();
				AbstractQueryResult rightRes = QRES.getInstance().pop(false);
				
				if(rightRes instanceof BagResult && ((BagResult) rightRes).getElements().size() > 1) {
					throw new SBQLEvalException("AnyOperator.visit - rezultat nie jest pojedynczym elementem");
				} else {
					rightRes = Util.deref(rightRes);
				}
				
				if(rightRes instanceof BooleanResult && ((BooleanResult) rightRes).isValue()) {
					QRES.getInstance().push(rightRes);
					return;
				} 
			}
		} else {
			List<ENVSBinder> binders = ENVS.getInstance().nested(res);
			anyOperator.getRightExpression().accept(this);
			//if(binders.size() > 0)
				ENVS.getInstance().pop();
			AbstractQueryResult rightRes = QRES.getInstance().pop(false);
			
			if(rightRes instanceof BagResult && ((BagResult) rightRes).getElements().size() > 1) {
				throw new SBQLEvalException("AnyOperator.visit - rezultat nie jest pojedynczym elementem");
			} else {
				rightRes = Util.deref(rightRes);
			}
			
			if(rightRes instanceof BooleanResult && ((BooleanResult) rightRes).isValue()) {
				QRES.getInstance().push(rightRes);
				return;
			}
		}
		QRES.getInstance().push(new BooleanResult(false));
	}

	public void visitSumExpression(SumOperator sumOperator) {
		sumOperator.getInnerExpression().accept(this);
		sumOperator.eval();
	}

	public void visitMinExpression(MinOperator minOperator) {
		minOperator.getInnerExpression().accept(this);
		minOperator.eval();
	}

	public void visitMaxExpression(MaxOperator maxOperator) {
		maxOperator.getInnerExpression().accept(this);
		maxOperator.eval();
	}

	public void visitCountExpression(CountOperator countOperator) {
		countOperator.getInnerExpression().accept(this);
		countOperator.eval();	
	}

	public void visitIntersectExpression(IntersectOperator intersectOperator) {
		intersectOperator.getLeftExpression().accept(this);
		intersectOperator.getRightExpression().accept(this);
		intersectOperator.eval();
	}

	public void visitMinusExpression(MinusOperator minusOperator) {
		minusOperator.getLeftExpression().accept(this);
		minusOperator.getRightExpression().accept(this);
		minusOperator.eval();
	}

	public void visitMinusUnaryOperator(MinusUnaryOperator minusUnaryOperator) {
		minusUnaryOperator.getInnerExpression().accept(this);
		minusUnaryOperator.eval();	
	}

	public void visitPlusUnaryOperator(PlusUnaryOperator plusUnaryOperator) {
		plusUnaryOperator.getInnerExpression().accept(this);
		plusUnaryOperator.eval();
	}

	@Override
	public void visitGetActualOwner(GetActualOwnerFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitGetBusinessAdministrators(GetBusinessAdministratorsFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitGetCountOfFinishedSubTasks(GetCountOfFinishedSubTasksFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitGetCountOfSubTasks(GetCountOfSubTasksFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitGetCountOfSubTasksInState(GetCountOfSubTasksInStateFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitGetCountOfSubTasksWithOutcome(GetCountOfSubTasksWithOutcomeFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitGetExcludedOwners(GetExcludedOwnersFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitGetInput(GetInputFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitGetLogicalPeopleGroup(GetLogicalPeopleGroupFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitGetOutcome(GetOutcomeFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitGetOutput(GetOutputFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitGetPotentialOwners(GetPotentialOwnersFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitGetSubtaskOutput(GetSubtaskOutputFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitGetSubtaskOutputs(GetSubtaskOutputsFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitGetTaskInitiator(GetTaskInitiatorFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitGetTaskPriority(GetTaskPriorityFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitGetTaskStakeholders(GetTaskStakeholdersFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitWaitFor(WaitForFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitWaitUntil(WaitUntilFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitExcept(ExceptFunction o) {
		o.getLeftExpression().accept(this);
		o.getRightExpression().accept(this);
		o.eval();
	}

	@Override
	public void visitVote(VoteFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
		
	}

	@Override
	public void visitConcate(ConcatFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
	}

	@Override
	public void visitConcatWithDelimiter(ConcatWithDelimiterFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
	}

	@Override
	public void visitLeastFrequentOccurence(LeastFrequentOccurenceFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
	}

	@Override
	public void visitMostFrequentOccurence(MostFrequentOccurenceFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
	}

	@Override
	public void visitVoteOnString(VoteOnStringFunction o) {
		o.getInnerExpression().accept(this);
		o.eval();
	}

	@Override
	public void visitAvgExpression(AvgOperator o) {
		o.getInnerExpression().accept(this);
		o.eval();
	}


}
