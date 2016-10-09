package slack.android.api.webapi.response;

import java.util.List;

import slack.android.api.models.Bot;
import slack.android.api.models.Channel;
import slack.android.api.models.Group;
import slack.android.api.models.Im;
import slack.android.api.models.Mpim;
import slack.android.api.models.Self;
import slack.android.api.models.Team;
import slack.android.api.models.User;

public class RtmStartResponse extends BaseResponse {

    private String url;

    private Self self;

    private Team team;
    private List<User> users;
    private List<Channel> channels;
    private List<Group> groups;
    private List<Mpim> mpims;
    private List<Im> ims;
    private List<Bot> bots;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Mpim> getMpims() {
        return mpims;
    }

    public void setMpims(List<Mpim> mpims) {
        this.mpims = mpims;
    }

    public List<Im> getIms() {
        return ims;
    }

    public void setIms(List<Im> ims) {
        this.ims = ims;
    }

    public List<Bot> getBots() {
        return bots;
    }

    public void setBots(List<Bot> bots) {
        this.bots = bots;
    }
}
