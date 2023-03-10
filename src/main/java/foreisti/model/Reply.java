package foreisti.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Reply extends Post {
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name="thread_id")
	private Thread thread;

	public Thread getThread() { return thread; }
	public void setThread(Thread t) { thread = t; }
}
