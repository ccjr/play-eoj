ActionController::Routing::Routes.draw do |map|
  map.resources :cards
  map.root :controller => 'cards'
end