set :domain,      "rida@scm.spinbits.com"
set :deploy_to,   "/mnt/www/rails/eoj"
set :scm,         "git"
set :repository,  "git://github.com/ccjr/play-eoj.git"

namespace :vlad do
  desc 'Runs vlad:update, vlad:migrate, vlad:restart_passenger'
  task :deploy => ['vlad:update', 'vlad:migrate', 'vlad:restart_passenger']
  
  desc 'Touch file'
  remote_task :restart_passenger, :roles => :app do
    run "cd #{current_path} && touch tmp/restart.txt"
  end

  remote_task :update do
    run "cp #{deploy_to}/shared/production.sqlite3 #{current_path}/db/"
    run "cp #{deploy_to}/shared/database.yml #{current_path}/config/"
  end
end