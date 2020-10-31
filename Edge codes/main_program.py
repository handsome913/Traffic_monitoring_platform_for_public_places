from UI_class import ui
from get_image_from_video import get_img_from_camera_local
from get_output import write_to_json
import time
# from data_sent import send


def conversion_interval(time_str):
    second_str = 0
    if time_str == "10秒":
        second_str = 10
    elif time_str == "20秒":
        second_str = 20
    elif time_str == "30秒":
        second_str=30
    elif time_str=="1分钟":
        second_str=60
    elif time_str=="3分钟":
        second_str=3*60
    elif time_str=="5分钟":
        second_str=5*60
    elif time_str=="10分钟":
        second_str=10*60
    elif time_str=="30分钟":
        second_str=30*60
    elif time_str=="1小时":
        second_str=1*60*60
    return second_str

def conversion_threshold(threshold_str):
    threshold_num = 0
    if threshold_str == "1人":
        threshold_num = 1
    elif threshold_str == "3人":
        threshold_num=3
    elif threshold_str=="5人":
        threshold_num=5
    elif threshold_str=="10人":
        threshold_num=10
    elif threshold_str=="20人":
        threshold_num=20
    elif threshold_str=="30人":
        threshold_num=30
    elif threshold_str=="50人":
        threshold_num=50
    elif threshold_str=="100人":
        threshold_num=100
    return threshold_num


# 图形界面程序
application=ui()



# print("....")
# print(application.flag)
# 将得到的文件路径变为python能够识别的路径
if application.flag:
    # print(application.flag)

    # 将选中的存放截取照片的文件夹路径转换成python能够识别的路径
    # file_path=application.file_path_str.replace("/","\\\\")+"\\\\"
    print(application.file_path_str)
    file_path = application.file_path_str+"/"
    print(file_path)
    # 将选中的截取照片的时间间隔的字符串转换成数字形式
    screenshot_interval = conversion_interval(application.cv.get())
    # 将识别人数的阈值的字符串转换成数字
    threshold_value = conversion_threshold(application.threshold_value.get())

    # 将计算出来的的每张照片的人数发送给固定的网址
    upload_address=application.upload_address.get()

    # 检测地点
    detect_location=application.location_value.get()
    print(detect_location)

    # 从视频中截取图片存入相应的文件夹
    get_img_from_camera_local(upload_address,file_path,screenshot_interval,threshold_value,detect_location)

    # 将截图中的人数统计出来并将其输入到json文件中
    # write_to_json(file_path,threshold_value)

    # 将计算出来的的每张照片的人数发送给固定的网址
    # upload_address=application.upload_address
    # send(upload_address)