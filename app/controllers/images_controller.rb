class ImagesController < ApplicationController
  def upload
  	image_data = params[:image_data]

  	image_decoded = image_data.tr('-_','+/').unpack('m')[0]

  	File.open("#{Rails.root.to_s}/public/tmp/#{Time.now.to_i}_#{rand(1..10000)}_imagem.jpeg",'wb') do |f|
			f.write image_decoded
		end
  end
end
