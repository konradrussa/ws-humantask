package test.task.definition;

import org.junit.Assert;
import org.oasis_open.docs.ns.bpel4people.ws_humantask._200803.THumanInteractions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.utils.ResourceUtil;
import wsht.infrastructure.domain.entity.HumanInteractions;
import wsht.marshalling.IBeanMapper;
import wsht.marshalling.IJAXBUtilBean;
import wsht.marshalling.exception.RejectedMessageException;
import wsht.marshalling.exception.WSHTException;

public class TestTaskDefinition {
	
	@org.junit.Test
	public void testMarshalling() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		
		try {
			IJAXBUtilBean jaxbUtilBean = (IJAXBUtilBean) context.getBean("jaxbUtilBean");
			THumanInteractions interaction = jaxbUtilBean.parseAndUnmarshal(ResourceUtil.loadToString("oasis_example.xml"));
			Assert.assertNotNull(interaction);
			IBeanMapper mapper = (IBeanMapper) context.getBean("beanMapper");
			HumanInteractions hi = mapper.map(interaction, HumanInteractions.class);
			Assert.assertNotNull(hi);
			
		} catch (WSHTException e) {
			e.printStackTrace();
		} catch (RejectedMessageException e) {
			e.printStackTrace();
		}
	}
}
