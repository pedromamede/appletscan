Appletscan::Application.routes.draw do
 
  resources :images


 root :to => "scanners#scanner_applet"
 
end
