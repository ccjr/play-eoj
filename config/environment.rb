# Specifies gem version of Rails to use when vendor/rails is not present
RAILS_GEM_VERSION = '2.2.2' unless defined? RAILS_GEM_VERSION

# Bootstrap the Rails environment, frameworks, and default configuration
require File.join(File.dirname(__FILE__), 'boot')

Rails::Initializer.run do |config|
  config.time_zone = 'UTC'
  config.action_controller.session = {
    :session_key => '_eoj-card-browser_session',
    :secret      => '9081ed221f9509a7027a6bc34608ee2a94b793a76be3c618cc5be597428a9443eda28fc27108f3c33cece4819392b2b05dd379c09491b4ce370782e43af7e75a'
  }
  config.gem "haml"
end