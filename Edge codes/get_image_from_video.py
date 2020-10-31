import cv2
import datetime
from get_output import write_to_json

# 获取本地摄像头
# folder_path 截取图片的存储目录
def get_img_from_camera_local(upload_address,folder_path,screenshot_interval, threshold,detect_location):
	cap = cv2.VideoCapture(0)
	# 每screenshot_interval秒钟截一次图片
	time_interval=datetime.timedelta(seconds=screenshot_interval)
	# 开始时间
	start_time=datetime.datetime.now()
	while True:
		ret, frame = cap.read()
		cv2.imshow("capture", frame)
		#当前时间
		current_time=datetime.datetime.now()
		# times=int((current_time-start_time).total_seconds())%int(time_interval.total_seconds())
		# 当前时间去上一次截取时间的时间差
		before_now=(current_time-start_time).total_seconds()

		# 时间差=screenshot_interval则截取图片
		if int(before_now)==screenshot_interval:
			start_time = current_time
			# 以当前时间作为图片名
			photo_name=current_time.strftime("%Y%m%d%H%M%S")

			# 存储为图像
			cv2.imwrite(folder_path + photo_name  + '.jpg', frame)
			# 将截取到的文件分析提取人数，并将其写入json文件
			write_to_json(folder_path, threshold, upload_address,detect_location)


		if cv2.waitKey(1) & 0xFF == ord('q'):
			break
	cap.release()
	cv2.destroyAllWindows()



# # 获取网络摄像头，格式：rtsp://username:pwd@ip/
# # folder_path 截取图片的存储目录
def get_img_from_camera_net(upload_address,folder_path,video_path,screenshot_interval, threshold):
	# cap = cv2.VideoCapture('rtsp://username:pwd@ip/')
	cap = cv2.VideoCapture(video_path)
	# 每screenshot_interval秒钟截一次图片
	time_interval=datetime.timedelta(seconds=screenshot_interval)
	# 开始时间
	start_time=datetime.datetime.now()
	while True:
		ret, frame = cap.read()
		cv2.imshow("capture", frame)
		#当前时间
		current_time=datetime.datetime.now()
		# times=int((current_time-start_time).total_seconds())%int(time_interval.total_seconds())
		# 当前时间去上一次截取时间的时间差
		before_now=(current_time-start_time).total_seconds()

		# 时间差=screenshot_interval则截取图片
		if int(before_now)==screenshot_interval:
			start_time = current_time
			# 以当前时间作为图片名
			photo_name=current_time.strftime("%Y%m%d%H%M%S")

			# 存储为图像
			cv2.imwrite(folder_path + photo_name  + '.jpg', frame)
			# 将截取到的文件分析提取人数，并将其写入json文件
			write_to_json(folder_path, threshold, upload_address)

		if cv2.waitKey(1) & 0xFF == ord('q'):
			break
	cap.release()
	cv2.destroyAllWindows()

# 测试


# if __name__ == '__main__':


# folder_path = 'D:\\python_work\\identify\\image\\'

# folder_path="D:/test/"
# video_path = 'D:/video.mp4'


# 	folder_path=file_path_str.replace("/","\\\\")
# 	folder_path+="\\"
# 	print(folder_path)
# 	# folder_path=path_str.replace("")
#


# get_img_from_camera_local(folder_path,10)
# get_img_from_camera_net(folder_path,video_path)