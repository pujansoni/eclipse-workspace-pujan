package jsoupaccess;

import java.sql.Timestamp;

public class Domain {
	private String domainHash;
	private String domainUrl;
	private boolean activated;
	private Timestamp modified;
	private Timestamp created;
	
	public String getDomainHash() {
		return domainHash;
	}
	
	public String getDomainUrl() {
		return domainUrl;
	}
	
	public boolean isActivated() {
		return activated;
	}
	
	public Timestamp getModified() {
		return modified;
	}
	
	public Timestamp getCreated() {
		return created;
	}

	public Domain(String domainHash, String domainUrl) {
		this.domainHash = domainHash;
		this.domainUrl = domainUrl;
	}

	public Domain(String domainHash, String domainUrl, boolean activated, Timestamp modified, Timestamp created) {
		this.domainHash = domainHash;
		this.domainUrl = domainUrl;
		this.activated = activated;
		this.modified = modified;
		this.created = created;
	}
}
