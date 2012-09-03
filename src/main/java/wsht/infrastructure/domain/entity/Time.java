package wsht.infrastructure.domain.entity;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.datatype.Duration;

public class Time {

	protected Duration timePeriod;
    
	@Temporal(TemporalType.TIMESTAMP)
    protected Date pointOfTime;
}
