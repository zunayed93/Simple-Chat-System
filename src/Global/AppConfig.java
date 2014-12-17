/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Global;

import CurrentDb.Tables.ServerSettingTable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alim
 */
public class AppConfig {

    public static final int MAX_TRY_LOGIN = 10;
    public static final boolean IS_TESTING = true;
    /**
     * returns path like this E:\Working\GitHub\Simple-Chat-System (without
     * slash)
     */

    public static String DIRECTORY_SEPERATOR = File.separator;

    private static String _appPath;
    private static String _pictureUploadPath;
    private static String _connectionString;
    private static String _connectionConfigTextFilePath = "server.loc";
    private static List<String> _configFileLines;

    public static ServerSettingTable ServerConfig;

    /**
     *
     * @return E:\Working\GitHub\Simple-Chat-System\server.loc
     */
    public static String getAbsoluteServerConfigFilePath() {
        return getAppPath() + DIRECTORY_SEPERATOR + _connectionConfigTextFilePath;
    }

    /**
     * @return path like this E:\Working\GitHub\Simple-Chat-System (without
     * slash)
     *
     */
    public static String getAppPath() {
        if (AppConfig._appPath == null) {
            try {
                AppConfig._appPath = new File(".").getCanonicalPath();
            } catch (IOException ex) {
                Logger.getLogger(AppConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return _appPath;
    }

    /**
     * E:\Working\GitHub\Simple-Chat-System\PictureUpload
     *
     * @return getAppPath() + DIRECTORY_SEPERATOR + "PictureUpload"
     */
    public static String getPictureUploadPath() {
        if (AppConfig._pictureUploadPath == null) {
            _pictureUploadPath = getAppPath() + DIRECTORY_SEPERATOR + "PictureUpload";
        }
        return _pictureUploadPath;
    }

    public static void readDefaultConfigFile() {
        try {
            _configFileLines = Files.readAllLines(Paths.get(getAbsoluteServerConfigFilePath()), Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(AppConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServerConfig = new ServerSettingTable();
        ServerConfig.ServerPort = Integer.parseInt(_configFileLines.get(IServerConfig.Port));
        ServerConfig.ServerIP = _configFileLines.get(IServerConfig.ServerIP);
        ServerConfig.ConnectionString = _configFileLines.get(IServerConfig.ConnectionString);
        
    }

    /**
     * @return the _connectionString
     */
    public static String getConnectionString() {
        if (_connectionString == null) {
            readDefaultConfigFile();
        }
        return _connectionString;
    }

    /**
     * @param aConnectionString the _connectionString to set
     */
    public static void setConnectionString(String aConnectionString) {
        _connectionString = aConnectionString;
    }

    public AppConfig() {

    }
}
