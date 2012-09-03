package wsht.runtime.expressions.sbql.store.infrastructure;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.signature.SignatureVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wsht.infrastructure.utils.ReflectionUtils;
import wsht.marshalling.exception.WSHTException;
import wsht.runtime.exceptions.WSHTExpressionException;
import wsht.runtime.expressions.sbql.store.SBAStore;
import wsht.runtime.expressions.sbql.store.object.SimpleObject;

public class ASMVisitorWithSBAProcessing extends SBAProcessing implements AnnotationVisitor, SignatureVisitor,
										 ClassVisitor, FieldVisitor, MethodVisitor {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ASMVisitorWithSBAProcessing.class);
	
	public ASMVisitorWithSBAProcessing(SBAStore sbaStore, Object obj) {
		super(sbaStore, obj);
		objects.push(obj);
	}


	public void process() throws WSHTExpressionException {
		try {
			currentObject = objects.peek();
			new ClassReader(currentObject.getClass().getName()).accept(this, 0);
			objects.pop();
			if(objects.size() > 0) {
				currentObject = objects.peek();
			}
			objectFieldName = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	// ClassVisitor

	public void visit(final int version, final int access, final String name,
			final String signature, final String superName,
			final String[] interfaces) {
		

		if(!taskContainerNotProcesseed) {
			createFirstEntry(currentObject.getClass().getSimpleName());
			taskContainerNotProcesseed = true;
		} else {
			complexObject = processComplexObject(returnObjectName(), complexObject); //from currentObject
		}
	}

	public AnnotationVisitor visitAnnotation(final String desc, final boolean visible) {
		return this;
	}

	public void visitAttribute(final Attribute attr) {
	}

	public FieldVisitor visitField(final int access, final String name,
			final String desc, final String signature, final Object value) {
		
		if(name.contains("this") || name.contains("serialVersionUID")) return this;
		
		
		try {
			
			Field f = currentObject.getClass().getDeclaredField(name);
			f.setAccessible(true);
			Object childObject = f.get(currentObject);
			
			if(signature != null) {
				if(ReflectionUtils.checkIfListSignature(signature)) {
					for(Object o : (List<?>)childObject) {
						System.out.println("LIST : " + o.getClass().getName());
						if(ReflectionUtils.checkIfComplexClass(o.getClass())) {
							objects.push(o);
							process();
						} else {
							processSimpleObject(name, o);
						}
					}
				}
				if(ReflectionUtils.checkIfSetSignature(signature)) {
					for(Object o : (Set<?>)childObject) {
						if(ReflectionUtils.checkIfComplexClass(o.getClass())) {
							objects.push(o);
							process();
						} else {
							processSimpleObject(name, o);
						}
					}
				}
				if(ReflectionUtils.checkIfMapSignature(signature)) {
					for(Entry<?, ?> o : ((Map<?, ?>)childObject).entrySet()) {
						if(ReflectionUtils.checkIfComplexClass(o.getValue().getClass())) {
							objects.push(o.getValue());
							process();
						} else {
							processSimpleObject(name, o.getValue());
						}
					}
				}
			} else {
				
				if(childObject != null) {
					if(ReflectionUtils.checkIfComplexClass(childObject.getClass())) {
						objects.push(childObject);
						objectFieldName = name;
						process();
					} else {
						processSimpleObject(name, childObject);
					}
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
		return this;
	}

	public MethodVisitor visitMethod(final int access, final String name,
			final String desc, final String signature, final String[] exceptions) {

		return this;
	}

	public void visitSource(final String source, final String debug) {
	}

	public void visitInnerClass(final String name, final String outerName,
			final String innerName, final int access) {

	}

	public void visitOuterClass(final String owner, final String name,
			final String desc) {
	}

	// MethodVisitor

	public AnnotationVisitor visitParameterAnnotation(final int parameter,
			final String desc, final boolean visible) {
		
		return this;
	}

	public void visitTypeInsn(final int opcode, final String type) {
		
	}

	public void visitFieldInsn(final int opcode, final String owner,
			final String name, final String desc) {
		
	}

	public void visitMethodInsn(final int opcode, final String owner,
			final String name, final String desc) {
		
	}

	public void visitLdcInsn(final Object cst) {
		
	}

	public void visitMultiANewArrayInsn(final String desc, final int dims) {
		
	}

	public void visitLocalVariable(final String name, final String desc,
			final String signature, final Label start, final Label end,
			final int index) {
		
	}

	public AnnotationVisitor visitAnnotationDefault() {
		return this;
	}

	public void visitCode() {
	}

	public void visitFrame(final int type, final int nLocal,
			final Object[] local, final int nStack, final Object[] stack) {
	}

	public void visitInsn(final int opcode) {
	}

	public void visitIntInsn(final int opcode, final int operand) {
	}

	public void visitVarInsn(final int opcode, final int var) {
	}

	public void visitJumpInsn(final int opcode, final Label label) {
	}

	public void visitLabel(final Label label) {
	}

	public void visitIincInsn(final int var, final int increment) {
	}

	public void visitTableSwitchInsn(final int min, final int max,
			final Label dflt, final Label[] labels) {
	}

	public void visitLookupSwitchInsn(final Label dflt, final int[] keys,
			final Label[] labels) {
	}

	public void visitTryCatchBlock(final Label start, final Label end,
			final Label handler, final String type) {
		
	}

	public void visitLineNumber(final int line, final Label start) {
	}

	public void visitMaxs(final int maxStack, final int maxLocals) {
	}

	// AnnotationVisitor

	public void visit(final String name, final Object value) {
		
	}

	public void visitEnum(final String name, final String desc,
			final String value) {
		
	}

	public AnnotationVisitor visitAnnotation(final String name,
			final String desc) {
		
		return this;
	}

	public AnnotationVisitor visitArray(final String name) {
		return this;
	}

	// SignatureVisitor

	public void visitFormalTypeParameter(final String name) {
	}

	public SignatureVisitor visitClassBound() {
		return this;
	}

	public SignatureVisitor visitInterfaceBound() {
		return this;
	}

	public SignatureVisitor visitSuperclass() {
		return this;
	}

	public SignatureVisitor visitInterface() {
		return this;
	}

	public SignatureVisitor visitParameterType() {
		return this;
	}

	public SignatureVisitor visitReturnType() {
		return this;
	}

	public SignatureVisitor visitExceptionType() {
		return this;
	}

	public void visitBaseType(final char descriptor) {
	}

	public void visitTypeVariable(final String name) {
	}

	public SignatureVisitor visitArrayType() {
		return this;
	}

	public void visitClassType(final String name) {
		
	}

	public void visitInnerClassType(final String name) {
		
	}

	public void visitTypeArgument() {
	}

	public SignatureVisitor visitTypeArgument(final char wildcard) {
		return this;
	}

	// common

	public void visitEnd() {
	}
}
