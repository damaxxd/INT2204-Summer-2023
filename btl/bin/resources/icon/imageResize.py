from PIL import Image
 
ImgName = "download.png"
savedImgName = "history_icon.png"
path = "C:/Users/admin/Works/jva/oop/INT2204-Summer-2023/btl/src/resources/icon/" + ImgName
im = Image.open(path)

newsize = (30, 30)
im = im.resize(newsize)
im.save(savedImgName)