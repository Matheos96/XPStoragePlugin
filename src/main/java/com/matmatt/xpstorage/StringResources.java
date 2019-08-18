package com.matmatt.xpstorage;

class StringResources {

    static String XP_STORAGE = "[XPStorage]";

    static String XP_STORED = "Your XP-levels have been stored in this sign! \n" +
            "Left click the sign with an emerald in your hand to get them back!";

    static String MORE_XP_NEEDED = "You need at least one XP-level to be able to store since you can only" +
            " store whole levels!";

    static String XP_BACK = "Enjoy your XP-levels!";

    static String NO_XP_BACK = "Can't give XP back... Faulty sign line 3.";

    static String NOT_YOUR_XP = "These are not your XP-levels!";

    static String NO_BREAK_OTHERS_SIGNS = "You cannot break other players' XP signs!";

    static String NO_MANUAL_CREATION = "You are not allowed to manually create XPStorage signs!\n" +
            "To store your XP, create a blank birch sign and right click it with an emerald.";

    static String playerBrackets(String name ) {
        return "["+name+"]";
    }
}
