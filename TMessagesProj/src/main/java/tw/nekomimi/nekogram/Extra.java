package tw.nekomimi.nekogram;

import org.telegram.messenger.BuildConfig;

import tw.nekomimi.nekogram.helpers.UserHelper;

public class Extra {
    // https://core.telegram.org/api/obtaining_api_id
    public static final int APP_ID = 442495;
    public static final String APP_HASH = "873ffaceba76e791ff2491224a3cdb49";

    public static final String PLAYSTORE_APP_URL = "https://play.google.com/store/apps/details?id=tw.nekomimi.nekogram";

    private static final long WEBVIEW_BOT_ID = 101184875;

    public static String WS_USER_AGENT = "";
    public static String WS_CONN_HASH = "";
    public static String WS_DEFAULT_DOMAIN = "";

    public static String TWPIC_BOT_USERNAME = "TwPicBot";

    public static boolean FORCE_ANALYTICS = false;

    public static String TLV_URL = "https://tlv.kokkoro.eu.org/";

    public static boolean isDirectApp() {
        return "release".equals(BuildConfig.BUILD_TYPE) || "debug".equals(BuildConfig.BUILD_TYPE);
    }

    public static long getOwnerFromStickerSetId(long setId) {
        long result = setId >> 32;

        if (((setId >> 16) & 0xFF) == 0x3F) {
            result |= 0x80000000L;
        }

        boolean modifierIsPresent = ((setId >> 24) & 0xFF) != 0;

        return modifierIsPresent ? result + 0x100000000L : result;
    }

    public static UserHelper.BotInfo getHelperBot() {
        return new UserHelper.BotInfo() {
            @Override
            public long getId() {
                return 1190800416L;
            }

            @Override
            public String getUsername() {
                return "nekonotificationbot";
            }
        };
    }

    public static UserHelper.UserInfoBot getUserInfoBot(boolean fallback) {
        return null;
    }

    public static boolean isTrustedBot(long id) {
        return id == WEBVIEW_BOT_ID;
    }
}
