namespace :data do
  namespace :android do

    desc "Creates code to insert all definitions"
    task(:definitions => :environment) do
      puts "// GENERATED CODE, CHANGE IN data:android TASK"
      Definition.all(:order => 'name').each do |definition|
        puts "addDefinition(db, \"#{definition.name}\", \"#{definition.description}\");"
      end
    end
    
  end
end