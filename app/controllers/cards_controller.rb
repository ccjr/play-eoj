class CardsController < ApplicationController
  #caches_page :show, :list

  def show
    @card = Card.find params[:id]
  end
  
  def list
    @cards = Card.list params
  end  
end