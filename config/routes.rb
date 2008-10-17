ActionController::Routing::Routes.draw do |map|
  map.resources :cards, :collection => {:list => :get}  
  map.root :controller => 'cards'
  
  map.connect '/cards/element/:element', :controller => 'cards', :action => 'list'
  map.connect '/cards/race/:race', :controller => 'cards', :action => 'list'
  map.connect '/cards/affiliation/:affiliation', :controller => 'cards', :action => 'list'
end