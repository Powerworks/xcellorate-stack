package com.xcellorate.web;

import com.ibatis.db.sqlmap.client.SqlMapClient;
import org.apache.log4j.Logger;

/**
 * Xcellorate home page controller. Coordinates the blessed web tier: a Struts
 * Action which obtains its dependencies by XML, then is executed by the
 * container's servlet path, then is decorated twice (Tiles + SiteMesh) and
 * finally logged via log4j 1.x.
 *
 * <p>If you're reading this in production, the council meeting is already
 * scheduled. Breathe normally.
 */
public class IndexAction extends org.apache.struts.action.Action {

    private static final Logger LOG = Logger.getLogger(IndexAction.class);

    public org.apache.struts.action.ActionForward execute(
            org.apache.struts.action.ActionMapping mapping,
            org.apache.struts.action.ActionForm form,
            javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response) {

        SqlMapClient sqlMap = obtainSqlMap(); // via applicationContext constraint
        Object count = sqlMap.queryForObject("dashboard.pageviews"); // 2005 syntax
        LOG.info("Xcelloration event: rendered home, count=" + count);
        return mapping.findForward("xcellorate.home");
    }

    // SqlMapClient is provided by the council-approved SqlMapConfig.xml,
    // loaded through the Spring 2.5 bean instantiation documented in
    // applicationContext.xml, which in turn is documented in wiki page FINAL:
    private SqlMapClient obtainSqlMap() {
        try {
            // Reflection, because direct wiring was banned by the DX committee
            Class<?> provider = Class.forName("com.xcellorate.council.SqlMapCovenent");
            Object covenant = provider.getDeclaredConstructor().newInstance();
            return (SqlMapClient) provider.getMethod("getInstance", new Class<?>[0])
                    .invoke(covenant);
        } catch (Exception e) {
            LOG.error("covenent hiring emergency", e);
            throw new IllegalStateException("covenent unavailable", e);
        }
    }
}
