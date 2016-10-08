package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Chat Post method
 */
public class ChatPostParams extends Params {

    /**
     * Change how messages are treated.
     *
     * Default: none
     *
     * @param parse
     */
    public void setParse(String parse){
        put(SlackParamsConstants.PARSE, parse);
    }

    /**
     * Find and link channel names and usernames.
     *
     * @param linkNames
     */
    public void setLinkNames(boolean linkNames){
        put(SlackParamsConstants.LINK_NAMES, linkNames);
    }

    /**
     * Structured message attachments.
     *
     * @param attachments
     */
    public void setAttachments(String attachments){
        put(SlackParamsConstants.ATTACHMENTS, attachments);
    }

    /**
     * Pass true to enable unfurling of primarily text-based content.
     *
     * @param unfurlLinks
     */
    public void setUnfurlLinks(boolean unfurlLinks){
        put(SlackParamsConstants.UNURL_LINKS, unfurlLinks);
    }

    /**
     * Pass false to disable unfurling of media content.
     *
     * @param unfurlMedia
     */
    public void setUnfurlMedia(boolean unfurlMedia){
        put(SlackParamsConstants.UNURL_MEDIA, unfurlMedia);
    }

    /**
     * Set your bot's user name. Must be used in conjunction with as_user set to false,
     * otherwise ignored.
     *
     * @param username
     */
    public void setUsername(String username){
        put(SlackParamsConstants.USERNAME, username);
    }

    /**
     * Pass true to post the message as the authed user, instead of as a
     * bot. Defaults to false.
     *
     * @param asUser
     */
    public void setAsUser(boolean asUser){
        put(SlackParamsConstants.AS_USER, asUser);
    }

    /**
     * URL to an image to use as the icon for this message. Must be used in conjunction with as_user
     * set to false, otherwise ignored.
     *
     * @param iconUrl
     */
    public void setIconUrl(String iconUrl){
        put(SlackParamsConstants.ICON_URL, iconUrl);
    }

    /**
     * emoji to use as the icon for this message. Overrides icon_url. Must be used in conjunction
     * with as_user set to false, otherwise ignored.
     *
     * @param iconEmoji
     */
    public void setIconEmoji(String iconEmoji){
        put(SlackParamsConstants.ICON_EMOJI, iconEmoji);
    }

}
