package com.clidone.tag.bootstrap;

/**
 * <strong>Bootstrap version chooser</strong>
 * <p>
 * According {@link com.clidone.DeviceDetector} detection result,
 * decide which Bootstrap version shoold use.
 * </p>
 * @author wuhuaxia
 */
public class VersionChooser {

    /**
     * Constructor
     */
    public VersionChooser() {
    }

    /**
     * When is Bootstrap version 2.*: true, else false
     * @return Bootstrap version 2.* flag
     */
    public boolean isV2() {
        return false;
    }

    /**
     * When is Bootstrap version 3.*: true, else false
     * @return Bootstrap version 3.* flag
     */
    public boolean isV3() {
        return false;
    }
}