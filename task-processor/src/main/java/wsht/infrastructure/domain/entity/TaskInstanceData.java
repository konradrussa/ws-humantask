package wsht.infrastructure.domain.entity;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;

import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.Renderings;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TAttachmentInfos;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TComments;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TFaultData;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TMessagePartsData;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TTaskDetails;

public class TaskInstanceData {

    @XmlElement(required = true)
    protected TTaskDetails taskDetails;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected TMessagePartsData input;
    @XmlElement(required = true, nillable = true)
    protected TMessagePartsData output;
    @XmlElementRef(name = "fault", namespace = "http://docs.oasis-open.org/ns/bpel4people/ws-humantask/types/200803", type = JAXBElement.class) //, required = false
    protected JAXBElement<TFaultData> fault;
    protected Renderings renderings;
    protected TComments comments;
    protected TAttachmentInfos attachmentInfos;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    
}
