package slack.android.api.models;

public class Team {
	private String id;
	private String name;
	private String domain;
	private String emailDomain;
	private Icons icon;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getEmailDomain() {
		return emailDomain;
	}

	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}

	public Icons getIcon() {
		return icon;
	}

	public void setIcon(Icons icon) {
		this.icon = icon;
	}
}
