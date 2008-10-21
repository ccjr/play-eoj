class CardsController < ApplicationController
  caches_page :show, :image #, :list

  def show
    @card = Card.find params[:id]
  end
  
  def image
    @card = Card.find params[:id]
  end
  
  def list
    @cards = Card.list params
    redirect_to @cards.first if (@cards.size == 1)
  end  
end