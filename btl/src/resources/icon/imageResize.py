from PIL import Image
 
ImgName = "download.png"
savedImgName = "history_icon.png"
path = "btl/src/resources/icon/" + ImgName
im = Image.open(path)

newsize = (30, 30)
im = im.resize(newsize)
im.save(savedImgName)