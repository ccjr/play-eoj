ActionController::Routing::Routes.draw do |map|
  map.resources :cards, :collection => {:list => :get}
  map.root :controller => 'cards'
end