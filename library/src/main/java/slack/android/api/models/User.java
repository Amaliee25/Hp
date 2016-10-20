package slack.android.api.models;

public class User {

	private String id;
	private String name;
	private Boolean deleted;
	private String color;
	private Profile profile;
	private Boolean isAdmin;
	private Boolean isOwner;
	private Boolean isPrimaryOwner;
	private Boolean isRestricted;
	private Boolean isUltraRestricted;
	private Boolean has2fa;
	private String twoFactorType;
	private Boolean hasFiles;
	private Message latest;

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

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Boolean getAdmin() {
		return isAdmin;
	}

	public void setAdmin(Boolean admin) {
		isAdmin = admin;
	}

	public Boolean getOwner() {
		return isOwner;
	}

	public void setOwner(Boolean owner) {
		isOwner = owner;
	}

	public Boolean getPrimaryOwner() {
		return isPrimaryOwner;
	}

	public void setPrimaryOwner(Boolean primaryOwner) {
		isPrimaryOwner = primaryOwner;
	}

	public Boolean getRestricted() {
		return isRestricted;
	}

	public void setRestricted(Boolean restricted) {
		isRestricted = restricted;
	}

	public Boolean getUltraRestricted() {
		return isUltraRestricted;
	}

	public void setUltraRestricted(Boolean ultraRestricted) {
		isUltraRestricted = ultraRestricted;
	}

	public Boolean getHas2fa() {
		return has2fa;
	}

	public void setHas2fa(Boolean has2fa) {
		this.has2fa = has2fa;
	}

	public String getTwoFactorType() {
		return twoFactorType;
	}

	public void setTwoFactorType(String twoFactorType) {
		this.twoFactorType = twoFactorType;
	}

	public Boolean getHasFiles() {
		return hasFiles;
	}

	public void setHasFiles(Boolean hasFiles) {
		this.hasFiles = hasFiles;
	}

	public Message getLatest() {
		return latest;
	}

	public void setLatest(Message latest) {
		this.latest = latest;
	}
}
