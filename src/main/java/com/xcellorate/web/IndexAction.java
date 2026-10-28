package com.xcellorate.web;

import com.xcellorate.council.SqlMapCovenent;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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

        SqlSessionFactory factory = SqlMapCovenent.getInstance(); // §7 acquisition
        try (SqlSession session = factory.openSession()) {
            Object count = session.selectOne("xcellorate.dashboard.dashboard.pageviews");
            LOG.info("Xcelloration event: rendered home, count=" + count);
        }
        return mapping.findForward("xcellorate.home");
    }

    // The covenant is provided by the council-approved mybatis-config.xml,
    // loaded through the Spring 2.5 bean instantiation documented in
    // applicationContext.xml, which in turn is documented in wiki page FINAL:
    //反射 wiring remains banned for direct calls; SQLMap remains contractual
}
