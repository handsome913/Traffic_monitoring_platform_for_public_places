import tkinter
from tkinter import ttk
from tkinter.filedialog import askdirectory

class ui(tkinter.Tk):
    def __init__(self):
        super().__init__()
        # self.win=tkinter.Tk()
        self.title("人流量检测设置页面")
        self.geometry("400x300+250+100")
        # 禁止窗口拉伸
        self.resizable(width=False,height=False)

        # 存放图片的文件夹的变量
        self.path_file = tkinter.StringVar()
        self.path_file.set("D:/python_work/identify/image")
        self.file_path_str = "D:/python_work/identify/image"
        # Combobox绑定的变量
        self.cv=tkinter.StringVar()
        # self.cv.set("20秒")
        self.interval="5min"
        self.location_value=tkinter.StringVar()
        # 阈值变量
        self.threshold_value=tkinter.Variable()
        # self.threshold_value.set("3人")
        # 上传地址变量
        self.upload_address=tkinter.StringVar()
        self.upload_address.set("http://10.10.64.221:8088/saveTraffic")
        # flag用来判断是否又“确定”按钮来结束界面，flag=True表示有“确定”按钮结束
        self.flag=False

        self.draw()



    def draw(self):
        self.create_location()
        self.create_threshold()
        self.create_interval()
        self.create_uploadpath()
        self.create_filepath()
        self.create_confirm()


        self.mainloop()

        # time.sleep(1)
        #
        # return True

    def get_threshold(self):
        # print(self.threshold_value)
        return self.threshold_value


    def create_location(self):
        frame_location=tkinter.Frame(self)
        frame_location.pack(pady=10)

        com_location=ttk.Combobox(frame_location,textvariable=self.location_value)
        label_location=tkinter.Label(frame_location,text="   检测地点   ").grid(row=0,column=0)
        com_location.grid(row=0,column=1)
        # 地点下拉数据
        com_location["value"]=("Soochow University","Changshu Institute of Technology","Suzhou University of Science and Technology")
        # 设置默认值
        com_location.current(0)
        com_location.bind("<<ComboboxSelected>>")


    def create_threshold(self):

        # 阈值标签
        frame_threshold = tkinter.Frame(self)
        # frame_threshold.grid(row=0,columnspan=2)
        frame_threshold.pack(pady=10)


        # entry_threshold = tkinter.Entry(frame_threshold,textvariable=self.threshold_value).grid(row=0, column=1)
        com_threshold = ttk.Combobox(frame_threshold,textvariable=self.threshold_value)
        label_threshold = tkinter.Label(frame_threshold, text="      阈值      ").grid(row=0, column=0)
        com_threshold.grid(row=0, column=1)
        # 设置下拉数据
        com_threshold["value"] = ("1人", "3人", "5人", "10人", "20人", "30人", "50人", "100人")
        # 设置默认值为只要图片中超过3人就将其保存到json文件中
        com_threshold.current(1)
        com_threshold.bind("<<ComboboxSelected>>")

    # 返回时间间隔
    def getinterval(self, event):
        print(self.cv.get())

    # 创建上传时间间隔控件
    def create_interval(self):
        # 上传时间间隔标签
        frame_interval = tkinter.Frame(self)
        frame_interval.pack(pady=10)
        # frame_interval.grid(row=1)

        label_interval = tkinter.Label(frame_interval, text="上传时间间隔").grid(row=0, column=0)

        # 下拉列表，选择时间间隔
        com = ttk.Combobox(frame_interval,textvariable=self.cv)
        com.grid(row=0, column=1)
        # 设置下拉数据
        com["value"] = ("10秒","20秒", "30秒", "1分钟", "3分钟", "5分钟", "10分钟", "30分钟", "1小时")
        # 设置默认值为5分钟
        com.current(1)
        com.bind("<<ComboboxSelected>>", self.getinterval)

    def End_UI(self):
        self.flag=True
        # print("ui_test")
        # print(self.flag)
        # self.quit()
        self.destroy()


    # 选择文件夹
    def selectPath(self,path_file):
        path_ = askdirectory()
        path_file.set(path_)
        self.file_path_str = path_file.get()

    # 创建选择街区图片文件夹控件
    def create_filepath(self):
        # 选中的文件夹变量


        frame_file = tkinter.Frame(self)
        frame_file.pack(pady=10)
        # frame_file.grid(row=2)

        label_file = tkinter.Label(frame_file, text="目标路径:").grid(row=0, column=0)
        entry_file = tkinter.Entry(frame_file, textvariable=self.path_file,bd=5,width=22).grid(row=0, column=1)
        button_file = tkinter.Button(frame_file, text="路径选择", command=lambda: self.selectPath(self.path_file)).grid(row = 0, column = 2)

    # 输入上传地址控件
    def create_uploadpath(self):
        # 上传地址
        # path_upload = tkinter.StringVar()

        frame_upload_address = tkinter.Frame(self)
        frame_upload_address.pack(pady=10)
        # frame_upload_address.grid(row=3)

        label_upload_address = tkinter.Label(frame_upload_address, text="   上传地址   ").grid(row=0, column=0)
        entry_upload_address = tkinter.Entry(frame_upload_address, textvariable=self.upload_address,bd=5,width=22).grid(row=0, column=1)

    # 确认按钮控件
    def create_confirm(self):
        button = tkinter.Button(self, text="确认", width=10, height=1, command=self.End_UI)
        button.pack(pady=20)
        # button.grid(row=4)

