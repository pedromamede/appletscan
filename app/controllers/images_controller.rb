class ImagesController < ApplicationController
  def upload
  	image_data = params[:image_data]
  	
  	image_decoded = image_data.tr('-_','+/').unpack('m')[0]
  	
  	File.open("testeImg.jpg",'wb') do |f|
			f.write image_decoded.read
		end
  end
end
