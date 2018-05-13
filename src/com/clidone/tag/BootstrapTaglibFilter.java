package com.clidone.tag;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <strong>Bootstrap taglib initialization filter (integrate with web application)</strong>
 * @author wuhuaxia
 */
public class BootstrapTaglibFilter implements Filter {

    private static final String PATH_SEPARATOR = String.valueOf(File.separatorChar);

    /**
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String tagVersion     = filterConfig.getInitParameter("version");
        String tagIcon        = filterConfig.getInitParameter("icon");
        String tagIconVersion = filterConfig.getInitParameter("iconVersion");
        String tagDeviceWidth = filterConfig.getInitParameter("deviceWidth");
        String tagConfig      = filterConfig.getInitParameter("configLocation");

        if (tagConfig != null) {
            try {
                // build config file absolute path
                String webContentPath = getWebContent();
                String absoluteConfigPath = join(new String[] {
                    webContentPath, tagConfig
                });

                File configFile = new File(absoluteConfigPath);
                if (!configFile.exists()) {
                    throw new ServletException("init BootstrapTaglib config failure: Can't locate config propertices file: " + absoluteConfigPath);
                }

                Properties properties = new Properties();
                properties.load(new FileInputStream(configFile));

                if (tagVersion == null) {
                    tagVersion = properties.getProperty(BootstrapConfigConst.BOOTSTRAP_TAGLIB_VERSION_KEY);
                }
                if (tagIcon == null) {
                    tagIcon = properties.getProperty(BootstrapConfigConst.BOOTSTRAP_TAGLIB_ICON_KEY);
                }
                if (tagIconVersion == null) {
                    tagIconVersion = properties.getProperty(BootstrapConfigConst.BOOTSTRAP_TAGLIB_ICON_VERSION_KEY);
                }
                if (tagDeviceWidth == null) {
                    tagDeviceWidth = properties.getProperty(BootstrapConfigConst.BOOTSTRAP_TAGLIB_DEVICE_WIDTH_KEY);;
                }

            } catch (IOException ex) {
                throw new ServletException("init BootstrapTaglib config failure: Can't load config propertices file.");

            } catch (ServletException servletEx) {
                throw servletEx;
            }
        }

        // validate configuration
        if (ValueUtils.isEmpty(tagVersion)) {
            throw new ServletException("init BootstrapTaglib config failure: Version config is empty.");
        }
        tagVersion = tagVersion.trim();

        if (ValueUtils.isEmpty(tagDeviceWidth)) {
            tagDeviceWidth = BootstrapConfigConst.DEVICE_WIDTH_NAME;
        }

        // Cache configurations in ServletContext
        filterConfig.getServletContext().setAttribute(BootstrapConfigConst.BOOTSTRAP_TAGLIB_VERSION_KEY,      tagVersion);
        filterConfig.getServletContext().setAttribute(BootstrapConfigConst.BOOTSTRAP_TAGLIB_ICON_KEY,         tagIcon);
        filterConfig.getServletContext().setAttribute(BootstrapConfigConst.BOOTSTRAP_TAGLIB_ICON_VERSION_KEY, tagIconVersion);
        filterConfig.getServletContext().setAttribute(BootstrapConfigConst.BOOTSTRAP_TAGLIB_DEVICE_WIDTH_KEY, tagDeviceWidth);
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {
    }

    /**
     * Get WebContent absolute path
     * @return WebContent absolute path
     */
    private final String getWebContent() {
        String classesPath = BootstrapTaglibFilter.class.getResource("/").getPath();
        if (!classesPath.startsWith(PATH_SEPARATOR) && !isWindows()) {
            classesPath = PATH_SEPARATOR + classesPath;
        }
        if (!classesPath.endsWith(PATH_SEPARATOR)) {
            classesPath += PATH_SEPARATOR;
        }

        File file = new File(classesPath);
        String webContentPath = file.getParentFile().getParent();
        if (!webContentPath.endsWith(PATH_SEPARATOR)) {
            webContentPath += PATH_SEPARATOR;
        }
        return webContentPath;
    }

    /**
     * Join path
     * @param dir Direction
     * @return join direction
     */
    private final String join(String[] dir) {
        StringBuilder pathBuilder = new StringBuilder(400);

        if (dir != null) {
            String currentDir = null;

            for (int i=0,len=dir.length; i<len; i++) {
                if (dir[i] == null) {
                    continue;
                }
                currentDir = String.valueOf(dir[i]);
                if (currentDir == null || "".equals(currentDir.trim())) {
                    continue;
                }
                if (currentDir.startsWith(PATH_SEPARATOR) && pathBuilder.length() > 0) {
                    currentDir = currentDir.substring(1, currentDir.length());
                }
                pathBuilder.append(currentDir);
                if (!currentDir.endsWith(PATH_SEPARATOR) && i!=(len - 1)) {
                    pathBuilder.append(PATH_SEPARATOR);
                }
            }
        }

        return pathBuilder.toString();
    }

    /**
     * Check whether is windows OS or not
     * @return Windows OS: true, otherwise false,
     */
    private final boolean isWindows() {
        return (System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1);
    }
}