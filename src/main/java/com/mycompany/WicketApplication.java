/*
 * This is free and unencumbered software released into the public domain.
 */
package com.mycompany;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

/**
 * Fortressdemo1 Wicket home.
 *
 * @author Shawn McKinney
 * @version $Rev$
 */
public class WicketApplication extends WebApplication
{    	
    @Override
    public Session newSession(Request request, Response response)
    {
        return new RbacSession(request);
    }

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return LaunchPage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
		// add your configuration here
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        getMarkupSettings().setStripWicketTags(true);
        mountPage("home.html", LaunchPage.class);
	}
}
