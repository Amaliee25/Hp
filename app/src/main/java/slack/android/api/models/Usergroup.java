package slack.android.api.models;

import java.util.List;


public class Usergroup {
	private String id;
	private String teamId;
	private Boolean isUsergroup;
	private String name;
	private String description;
	private String handle;
	private Boolean isExternal;
	private Long dateCreate;
	private Long dateUpdate;
	private Long dateDelete;
	private String autoType;
	private String createdBy;
	private String updatedBy;
	private String deletedBy;
	// private String prefs;
	private List<String> users;
	private Integer userCount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public Boolean getUsergroup() {
		return isUsergroup;
	}

	public void setUsergroup(Boolean usergroup) {
		isUsergroup = usergroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public Boolean getExternal() {
		return isExternal;
	}

	public void setExternal(Boolean external) {
		isExternal = external;
	}

	public Long getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Long dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Long getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Long dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Long getDateDelete() {
		return dateDelete;
	}

	public void setDateDelete(Long dateDelete) {
		this.dateDelete = dateDelete;
	}

	public String getAutoType() {
		return autoType;
	}

	public void setAutoType(String autoType) {
		this.autoType = autoType;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}
}
