package slack.android.api.models;

import java.util.List;

public class File {
    private String id;
    private long created;
    private long timestamp;
    private String name;
    private String title;
    private String mimetype;
    private String filetype;
    private String prettyType;
    private String user;
    private String mode;
    private boolean editable;
    private boolean isExternal;
    private String externalType;
    private String username;
    private long size;

    private String urlPrivate;
    private String urlPrivateDownload;

    private String thumb64;
    private String thumb80;
    private String thumb360;
    private String thumb360Gif;
    private int thumb360W;
    private int thumb360H;
    private String thumb480;
    private int thumb480W;
    private int thumb480H;
    private String thumb160;

    private String permalink;
    private String permalinkPublic;
    private String editLink;
    private String preview;
    private String previewHighlight;
    private long lines;
    private long linesMore;

    private boolean isPublic;
    private boolean publicUrlShared;
    private boolean displayAsBot;

    private List<String> channels;
    private List<String> group;
    private List<String> ims;

    private Comment initialComment;
    private int numStars;
    private boolean isStarred;

    private List<String> pinnedTo;
    private List<Reaction> reactions;

    private int commentsCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getPrettyType() {
        return prettyType;
    }

    public void setPrettyType(String prettyType) {
        this.prettyType = prettyType;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isExternal() {
        return isExternal;
    }

    public void setExternal(boolean external) {
        isExternal = external;
    }

    public String getExternalType() {
        return externalType;
    }

    public void setExternalType(String externalType) {
        this.externalType = externalType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getUrlPrivate() {
        return urlPrivate;
    }

    public void setUrlPrivate(String urlPrivate) {
        this.urlPrivate = urlPrivate;
    }

    public String getUrlPrivateDownload() {
        return urlPrivateDownload;
    }

    public void setUrlPrivateDownload(String urlPrivateDownload) {
        this.urlPrivateDownload = urlPrivateDownload;
    }

    public String getThumb64() {
        return thumb64;
    }

    public void setThumb64(String thumb64) {
        this.thumb64 = thumb64;
    }

    public String getThumb80() {
        return thumb80;
    }

    public void setThumb80(String thumb80) {
        this.thumb80 = thumb80;
    }

    public String getThumb360() {
        return thumb360;
    }

    public void setThumb360(String thumb360) {
        this.thumb360 = thumb360;
    }

    public String getThumb360Gif() {
        return thumb360Gif;
    }

    public void setThumb360Gif(String thumb360Gif) {
        this.thumb360Gif = thumb360Gif;
    }

    public int getThumb360W() {
        return thumb360W;
    }

    public void setThumb360W(int thumb360W) {
        this.thumb360W = thumb360W;
    }

    public int getThumb360H() {
        return thumb360H;
    }

    public void setThumb360H(int thumb360H) {
        this.thumb360H = thumb360H;
    }

    public String getThumb480() {
        return thumb480;
    }

    public void setThumb480(String thumb480) {
        this.thumb480 = thumb480;
    }

    public int getThumb480W() {
        return thumb480W;
    }

    public void setThumb480W(int thumb480W) {
        this.thumb480W = thumb480W;
    }

    public int getThumb480H() {
        return thumb480H;
    }

    public void setThumb480H(int thumb480H) {
        this.thumb480H = thumb480H;
    }

    public String getThumb160() {
        return thumb160;
    }

    public void setThumb160(String thumb160) {
        this.thumb160 = thumb160;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getPermalinkPublic() {
        return permalinkPublic;
    }

    public void setPermalinkPublic(String permalinkPublic) {
        this.permalinkPublic = permalinkPublic;
    }

    public String getEditLink() {
        return editLink;
    }

    public void setEditLink(String editLink) {
        this.editLink = editLink;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getPreviewHighlight() {
        return previewHighlight;
    }

    public void setPreviewHighlight(String previewHighlight) {
        this.previewHighlight = previewHighlight;
    }

    public long getLines() {
        return lines;
    }

    public void setLines(long lines) {
        this.lines = lines;
    }

    public long getLinesMore() {
        return linesMore;
    }

    public void setLinesMore(long linesMore) {
        this.linesMore = linesMore;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public boolean isPublicUrlShared() {
        return publicUrlShared;
    }

    public void setPublicUrlShared(boolean publicUrlShared) {
        this.publicUrlShared = publicUrlShared;
    }

    public boolean isDisplayAsBot() {
        return displayAsBot;
    }

    public void setDisplayAsBot(boolean displayAsBot) {
        this.displayAsBot = displayAsBot;
    }

    public List<String> getChannels() {
        return channels;
    }

    public void setChannels(List<String> channels) {
        this.channels = channels;
    }

    public List<String> getGroup() {
        return group;
    }

    public void setGroup(List<String> group) {
        this.group = group;
    }

    public List<String> getIms() {
        return ims;
    }

    public void setIms(List<String> ims) {
        this.ims = ims;
    }

    public Comment getInitialComment() {
        return initialComment;
    }

    public void setInitialComment(Comment initialComment) {
        this.initialComment = initialComment;
    }

    public int getNumStars() {
        return numStars;
    }

    public void setNumStars(int numStars) {
        this.numStars = numStars;
    }

    public boolean isStarred() {
        return isStarred;
    }

    public void setStarred(boolean starred) {
        isStarred = starred;
    }

    public List<String> getPinnedTo() {
        return pinnedTo;
    }

    public void setPinnedTo(List<String> pinnedTo) {
        this.pinnedTo = pinnedTo;
    }

    public List<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reaction> reactions) {
        this.reactions = reactions;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }
}
