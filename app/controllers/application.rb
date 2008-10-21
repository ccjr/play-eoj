# Filters added to this controller apply to all controllers in the application.
# Likewise, all the methods added will be available for all controllers.

class ApplicationController < ActionController::Base
  helper :all # include all helpers, all the time
  #before_filter :no_iphone_page
  
  # See ActionController::RequestForgeryProtection for details
  # Uncomment the :secret if you're not using the cookie session store
  protect_from_forgery # :secret => '93a408b2a07d69e489138242c5f5d0dc'
  
  include HoptoadNotifier::Catcher
  
  def no_iphone_page
    unless request.env["HTTP_USER_AGENT"] && request.env["HTTP_USER_AGENT"][/(Mobile\/.+Safari)/]
      redirect_to '/no-iphone.html'
    end
  end
end