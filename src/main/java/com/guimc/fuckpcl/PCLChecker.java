package com.guimc.fuckpcl;

import com.guimc.fuckpcl.utils.WindowUtils;

import java.io.File;
import java.util.Arrays;


/**
 * A library checks Plain Craft Launcher
 *
 * @author guimc, liuli (The UnlegitMC Team)
 */
public class PCLChecker {
    /**
     * run full PCL check
     *
     * @param mcDir        minecraft folder path
     * @param deleteFolder delete PCL data folder for next PCL deleted check
     * @return check result
     */
    public static boolean fullCheck(File mcDir, boolean deleteFolder) {
        // check if there is a window named PCL
        if (titleCheck())
            return true;

        // maybe the window not exists like close the window after launched , so we need to check the PCL data folder
        return folderCheck(mcDir, deleteFolder);

        // PCL is not exists in the PC
    }

    /**
     * <p>run PCL title check</p>
     *
     * <p>check if there exists a title name contained "Plain Craft Launcher"</p>
     *
     * @return check result
     */
    public static boolean titleCheck() {
        if (!WindowUtils.isWindows()) {
            return false;
        }
        // PCL Title "Plain Craft Launcher 2"
        final String targetStr = "Plain Craft Launcher";
        String[] titleList = WindowUtils.getWindowNames();
        for (int i = 0; i <= titleList.length; i++) {
            if (titleList[i].contains(targetStr)) {
                return true;
            }
        }
        return false;
    }

    /**
     * run PCL data folder check
     *
     * @param mcDir        minecraft folder path
     * @param deleteFolder delete PCL data folder for next PCL deleted check
     * @return check result
     */
    public static boolean folderCheck(File mcDir, boolean deleteFolder) {
//    require(mcDir.exists()) { "Argument \"mcDir\" is not exists" }
//    require(mcDir.isDirectory) { "Argument \"mcDir\" should be a folder" }


        _FolderCheck(mcDir, "PCL", false);
        boolean exists = false;

        exists = _FolderCheck(mcDir, "PCL", false) || _FolderCheck(mcDir, "versions", true);


        return exists;
    }

    private static boolean _FolderCheck(File mcDir, String child, boolean list) {
        boolean exists = false;


        File directory = new File(mcDir, child);
        if (directory.exists() /*检测PCL文件夹是否存在*/ && Arrays.stream(directory.listFiles()).toArray().length != 0/*检测文件夹内是否没有文件*/) {
            exists = true;
        }

        if (list) {
            File[] listedFiles = directory.listFiles();

            for (File f : listedFiles) {
                File pclVersionDataDir = new File(f, "PCL");
                if (pclVersionDataDir.exists() /*检测PCL文件夹是否存在*/ && Arrays.stream(pclVersionDataDir.listFiles()).toArray().length != 0/*检测文件夹内是否没有文件*/) {
                    exists = true;
                }
            }
        }
        return exists;
    }
}