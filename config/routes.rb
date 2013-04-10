Appletscan::Application.routes.draw do

  resources :images


 root :to => "scanners#scanner_applet"

 	match "/images/upload" => "images#upload"

end
