package com.zeno.util;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.zeno.po.MDKDLL_TransCommNotifyInfo;


public class getSDK {

    public static List<Devices> list2 = new ArrayList<Devices>();
    public static List<Devices> list1  = new ArrayList<Devices>();
    public static List<PointValuePairInfo> list3 = new ArrayList<PointValuePairInfo>();
    public static List<DeviceStatus> list4 = new ArrayList<DeviceStatus>();
    public static List<SensorStatus> list5 = new ArrayList<SensorStatus>();
    public static List<ServerStatus> list6 = new ArrayList<ServerStatus>();
    public static List<PointValuePairInfo> list7 = new ArrayList<PointValuePairInfo>();
    public static List<MDKDLL_TransCommNotifyInfo> list8 = new ArrayList<>();


    public interface Function extends Library {


        Function INSTANCE = (Function) Native.loadLibrary("MDKDll", Function.class);

        public int MDKDLL_Init(getSDK.MDKDLL_StatusCallback f);                                                //初始化
        public int MDKDLL_CleanUp();                                                                            //销毁
        public int MDKDLL_SetCallback(getSDK.MDKDLL_AllTypeCallback g);                                         //设置回调函数  （新增）
        public int MDKDLL_Connect(String ip, short port, String user, String password);                       //登录
        public int MDKDLL_Discon();                                                                             //断开连接
        public int MDKDLL_QueryDevIotStatus(String deviceId, int type);                                        //查询设备数据
        public int MDKDLL_QueryDevList(MDKDLL_DevInfo.ByReference[] devinfo,int nMaxCount,IntByReference nNUm);//查询设备列表   （新增）
        public int MDKDLL_QueryDevChannelInfo(String deviceId ,MDKDLL_ChannelInfo.ByReference[] chaninfo ,int nMaxCount,IntByReference num);//查询通道列表   （新增）
        public int MDKDLL_QueryDevStatus(String deviceId,IntByReference nDevStatus);                          //查询设备状态  1在线 2 断线  （新增）
        public int MDKDLL_QuerySensorList(String deviceId,MDKDLL_SensorInfo.ByReference[] info ,int nMaxCount,IntByReference num);
        public int MDKDLL_QueryMeasurePointList(String deviceId,int sensorId,MDKDLL_MeasurePointInfo.ByReference[] measurePointinfo ,int nMaxCount,IntByReference num);
        public int MDKDLL_QuerySensorStatus(String deviceId,int sensorId,IntByReference nDevStatus);
        public int MDKDLL_GetMeasurePointValue(String deviceId, int sensorId, String[] point, int nPointNum, MDKDLL_PointValuePairInfo.ByReference[] info, int nMaxCount, IntByReference nNum);
        public int MDKDLL_SetMeasurePointValue(String deviceId,int sensorId, MDKDLL_PointValuePairInfo.ByReference[] info, int nNum);


        //订阅传感器数据
        public int MDKDLL_SubscribeSensorData(String deviceId, int nTimeval, Boolean bSpecifySensor, int[] listSensorID, int nCount);

        //停止订阅
        public int MDKDLL_StopSubscribeSensorData(String deviceId,int lListenHandl);

        /**
         * 设置串口信息  2018.0411 新增
         * @param deviceId 设备ID
         * @param port 串口号
         * @param commType 串口类型
         * @param commProp 串口数据
         */
        public int MDKDLL_SetTransComm(String deviceId,int port,int commType,MDKDLL_TransComm.ByValue  commProp);

        /**
         * 发送串口数据 2018.0411 新增
         * @param deviceId 设备ID
         * @param port 串口号
         * @param buffer 数据
         * @param len 数据长度
         */
        public int MDKDLL_SendDataToTransComm(String deviceId,int port,byte[] buffer,int len);


        public int MDKDLL_GetDeviceInfo(String deviceId,MDKDLL_DeviceInfo.ByReference[] deviceInfo);


        //结构体的定义 老协议网关设备报警结构体 废弃
        public static class MDKDLL_IotValuePair extends Structure {
            public byte[] szDeviceId = new byte[32];
            public int nChannel;
            public int nAlarmType;
            public byte[] szValueName = new byte[128];
            public byte[] szValueUnit = new byte[128];
            public int nValueType;
            public int nValue;
            public float fValue;
            public byte[] szValue = new byte[128];
            public byte[] szReserve = new byte[32];

            public static class ByReference extends MDKDLL_IotValuePair implements Structure.ByReference {}

            public static class ByValue extends MDKDLL_IotValuePair implements Structure.ByValue {}

            @SuppressWarnings({ "rawtypes", "unchecked" })
            @Override
            protected List getFieldOrder() {
                List a = new ArrayList();
                a.add("szDeviceId");
                a.add("nChannel");
                a.add("nAlarmType");
                a.add("szValueName");
                a.add("szValueUnit");
                a.add("nValueType");
                a.add("nValue");
                a.add("fValue");
                a.add("szValue");
                a.add("szReserve");
                return a;
            }
        }

        //回调函数调, 人脸信息
        public static class MDKDLL_FacePic extends Structure {
            public byte[] szDeviceId = new byte[32];
            public int nChannel;
            public String szFacePic;
            public NativeLong nSize;
            public byte[] szReserve = new byte[32];


            public static class ByReference extends MDKDLL_FacePic implements Structure.ByReference {}

            public static class ByValue extends MDKDLL_FacePic implements Structure.ByValue {}

            @SuppressWarnings({ "rawtypes", "unchecked" })
            @Override
            protected List getFieldOrder() {
                List a = new ArrayList();
                a.add("szDeviceId");
                a.add("nChannel");
                a.add("szFacePic");
                a.add("nSize");
                a.add("szReserve");
                return a;
            }
        }

        //结构体的定义  MDKDLL_DevInfo   设备信息
        public static class MDKDLL_DevInfo extends Structure {
            public byte[] szDeviceId = new byte[32];
            public byte[] szManufactroy = new byte[64];
            public int nChannelNum;
            public int nAlarminNum;
            public int nAlarmoutNum;
            public byte[] szIP = new byte[256];
            public int nPort;
            public byte[] szReserve = new byte[32];


            public static class ByReference extends MDKDLL_DevInfo implements Structure.ByReference {}

            public static class ByValue extends MDKDLL_DevInfo implements Structure.ByValue {}

            @SuppressWarnings({ "rawtypes", "unchecked" })
            @Override
            protected List getFieldOrder() {
                List a = new ArrayList();
                a.add("szDeviceId");
                a.add("szManufactroy");
                a.add("nChannelNum");
                a.add("nAlarminNum");
                a.add("nAlarmoutNum");
                a.add("szIP");
                a.add("nPort");
                a.add("szReserve");
                return a;
            }
        }

        //结构体的定义  MDKDLL_DevStatus  设备状态
        public static class MDKDLL_DevStatus extends Structure {

            public byte[] szDeviceId = new byte[32];
            public int status;

            public static class ByReference extends MDKDLL_DevStatus implements Structure.ByReference {}
            public static class ByValue extends MDKDLL_DevStatus implements Structure.ByValue {}

            @SuppressWarnings({ "rawtypes", "unchecked" })
            @Override
            protected List getFieldOrder() {
                List a = new ArrayList();
                a.add("szDeviceId");
                a.add("status");
                return a;
            }
        }

        //结构体的定义  MDKDLL_ChannelInfo  通道信息
        public static class MDKDLL_ChannelInfo extends Structure {
            public int nChlType;
            public int nChlNum;
            public byte[] szChlName = new byte[256];

            public static class ByReference extends MDKDLL_ChannelInfo implements Structure.ByReference {}

            public static class ByValue extends MDKDLL_ChannelInfo implements Structure.ByValue {}

            @SuppressWarnings({ "rawtypes", "unchecked" })
            @Override
            protected List getFieldOrder() {
                List a = new ArrayList();
                a.add("nChlType");
                a.add("nChlNum");
                a.add("szChlName");
                return a;
            }
        }

        //结构体的定义  MDKDLL_MeasurePointInfo  测点值信息
        public static class MDKDLL_MeasurePointInfo extends Structure {

            public int sensorId ;//传感器id
            public byte[] pointId = new byte[32];//id
            public byte[] szName = new byte[64];//名称
            public byte[] customId = new byte[32];
            public byte[] szUnit = new byte[64];//测点值单位
            public byte[] szDesc = new byte[256];//描述
            public int nValueType; //值类型
            public int nRangeType;//取值范围类型 0不限制 1单个 2连续 3离散
            public double nMinValue;//最小值
            public double nMaxValue;//最大值
            public int nDiscreteNumber;
            public MDKDLL_IotDiscreteValue[] stDiscrete = new MDKDLL_IotDiscreteValue[64];//nRangeType == 3 时的离散描述
            public byte[] szReserve = new byte[256];//预留

            public static class ByReference extends MDKDLL_MeasurePointInfo implements Structure.ByReference {}
            public static class ByValue extends MDKDLL_MeasurePointInfo implements Structure.ByValue {}

            @SuppressWarnings({ "rawtypes", "unchecked" })
            @Override
            protected List getFieldOrder() {
                List a = new ArrayList();
                a.add("sensorId");
                a.add("pointId");
                a.add("szName");
                a.add("customId");
                a.add("szUnit");
                a.add("szDesc");
                a.add("nValueType");
                a.add("nRangeType");
                a.add("nMinValue");
                a.add("nMaxValue");
                a.add("nDiscreteNumber");
                a.add("stDiscrete");
                a.add("szReserve");
                return a;
            }
        }

        //结构体的定义  MDKDLL_PointValuePairInfo  新协议网关设备报警结构体
        public static class MDKDLL_PointValuePairInfo extends Structure {

            public byte[] szDeviceId = new byte[32];//设备id
            public int sensorId;//传感器id
            public byte[] pointId = new byte[32];//id
            public byte[] szName = new byte[64];//名称
            public byte[] szUnit = new byte[64];//测点值单位
            public int nValueType; //值类型
            public int nValue; //整型值,布尔值（0false 1ture)
            public double fValue; //浮点值
            public byte[] szValue = new byte[256];//字符串值
            public byte[] stTime = new byte[32];//数据采集时间(从前端获取）
            public byte[] szReserve = new byte[256];//预留

            public static class ByReference extends MDKDLL_PointValuePairInfo implements Structure.ByReference {}
            public static class ByValue extends MDKDLL_PointValuePairInfo implements Structure.ByValue {}

            @SuppressWarnings({ "rawtypes", "unchecked" })
            @Override
            protected List getFieldOrder() {
                List a = new ArrayList();
                a.add("szDeviceId");
                a.add("sensorId");
                a.add("pointId");
                a.add("szName");
                a.add("szUnit");
                a.add("nValueType");
                a.add("nValue");
                a.add("fValue");
                a.add("szValue");
                a.add("stTime");
                a.add("szReserve");
                return a;
            }
        }

        //结构体的定义  MDKDLL_DevStatus  传感器信息
        public static class MDKDLL_SensorInfo extends Structure {

            public int sensorId;
            public byte[] szName = new byte[64];
            public int nType;
            public byte[] szSubType = new byte[64];
            public int nPointCount;//测点个数
            public byte[] szReserve = new byte[256];

            public static class ByReference extends MDKDLL_SensorInfo implements Structure.ByReference {}
            public static class ByValue extends MDKDLL_SensorInfo implements Structure.ByValue {}

            @SuppressWarnings({ "rawtypes", "unchecked" })
            @Override
            protected List getFieldOrder() {
                List a = new ArrayList();
                a.add("sensorId");
                a.add("szName");
                a.add("nType");
                a.add("szSubType");
                a.add("nPointCount");
                a.add("szReserve");
                return a;
            }
        }

        //结构体的定义  MDKDLL_SensorStatus  传感器状态
        public static class MDKDLL_SensorStatus extends Structure {

            public byte[] szDeviceId = new byte[32];
            public int sensorId;
            public int status;

            public static class ByReference extends MDKDLL_SensorStatus implements Structure.ByReference {}
            public static class ByValue extends MDKDLL_SensorStatus implements Structure.ByValue {}

            @SuppressWarnings({ "rawtypes", "unchecked" })
            @Override
            protected List getFieldOrder() {
                List a = new ArrayList();
                a.add("szDeviceId");
                a.add("sensorId");
                a.add("status");
                return a;
            }
        }

        //结构体的定义  MDKDLL_IotDiscreteValue
        public static class MDKDLL_IotDiscreteValue extends Structure {


            public byte[] szValue = new byte[64];
            public byte[] szDescription = new byte[64];

            public static class ByReference extends MDKDLL_IotDiscreteValue implements Structure.ByReference {}
            public static class ByValue extends MDKDLL_IotDiscreteValue implements Structure.ByValue {}

            @SuppressWarnings({ "rawtypes", "unchecked" })
            @Override
            protected List getFieldOrder() {
                List a = new ArrayList();
                a.add("szValue");
                a.add("szDescription");
                return a;
            }
        }

        //结构体的定义  MDKDLL_TransComm
        public static class MDKDLL_TransComm extends Structure {

            public int nDataBit; //数据位：0-5位；1-6位；2-7位；3-8位；4-4位
            public int nStopBit; //停止位：0-1位；1-1.5位；2-2位
            public int nParity;  //校验位：0-NONE；1-ODD；2-EVEN；3-MARK；4-SPACE
            public int nRate;    //波特率：0-300；1-600；2-1200；3-2400；4-4800；5-9600；6-19200；7-38400；8-57600；9-115200

            public static class ByReference extends MDKDLL_TransComm implements Structure.ByReference {}
            public static class ByValue extends MDKDLL_TransComm implements Structure.ByValue {}

            @SuppressWarnings({ "rawtypes", "unchecked" })
            @Override
            protected List getFieldOrder() {
                List a = new ArrayList();
                a.add("nDataBit");
                a.add("nStopBit");
                a.add("nParity");
                a.add("nRate");
                return a;
            }
        }

        //结构体的定义  MDKDLL_DeviceInfo
        public static class MDKDLL_DeviceInfo extends Structure {

            public byte[] szDeviceId = new byte[32];		//设备id
            public byte[] manufacturer = new byte[64];    //厂商
            public byte[] model = new byte[64];			//型号
            public byte[] firmware = new byte[32];		//固件版本
            public int	videochannel;		//视频通道数
            public int	alarmchannel;		//报警通道数

            public static class ByReference extends MDKDLL_DeviceInfo implements Structure.ByReference {}
            public static class ByValue extends MDKDLL_DeviceInfo implements Structure.ByValue {}

            @SuppressWarnings({ "rawtypes", "unchecked" })
            @Override
            protected List getFieldOrder() {
                List a = new ArrayList();
                a.add("szDeviceId");
                a.add("manufacturer");
                a.add("model");
                a.add("firmware");
                a.add("videochannel");
                a.add("alarmchannel");
                return a;
            }
        }

        public static class MDKDLL_TransCommNotify extends Structure {

            public byte[] szDeviceId = new byte[32];		//设备id
            public int lTransChannel;
            public int dwSize;//信息大小
            public  byte pBuffer[] = new  byte[512];			                //串口信息

            public static class ByReference extends MDKDLL_TransCommNotify implements Structure.ByReference {}
            public static class ByValue extends MDKDLL_TransCommNotify implements Structure.ByValue {}

            @SuppressWarnings({ "rawtypes", "unchecked" })
            @Override
            protected List getFieldOrder() {
                List a = new ArrayList();
                a.add("szDeviceId");
                a.add("lTransChannel");
                a.add("dwSize");
                a.add("pBuffer");
                return a;
            }
        }


    }


    //回调函数声明 初始化init
    public interface MDKDLL_StatusCallback extends StdCallLibrary.StdCallCallback {
        public void StatusCallback(int tpye,int status);
    }

    //回调函数声明 设置回调函数
    public interface MDKDLL_AllTypeCallback extends StdCallLibrary.StdCallCallback {
        public void Data_new(int type, Pointer data);
    }


    //回调函数实现 init
    public static class Data_Realize implements MDKDLL_StatusCallback{
        @Override
        public void StatusCallback(int tpye, int status) {

            ServerStatus serverStatus = new ServerStatus();
            serverStatus.setTpye(tpye);
            serverStatus.setStatus(status);

            list6.add(serverStatus);

        }
    }

    //回调函数实现 setCallBack 设置回调函数
    public static class Data_Realize_setCallBack implements MDKDLL_AllTypeCallback{
        @Override
        public void Data_new(int type, Pointer data) {
            if (type ==1) { //type == 1 人脸图片回调
                byte[] szDeviceId = new byte[32];
                int[] nChannel = new int[1] ;
                NativeLong nSize = null;
                nSize = data.getNativeLong(32);
//                ByteByReference szFacePic =null;
//                String[] zFacePic = new String[128];
                byte[] szReserve = new byte[32];

                data.read(0, szDeviceId, 0, 31);
                data.read(32, nChannel, 0, 1);
//              data.read(36, szFacePic, 0, 0);
//              data.read(44, nSize, 0, 0);
                data.read(168, szReserve, 0, 31);
            }else if(type == 2){//新协议网关设备报警回调
                byte[] szDeviceId = new byte[32];//设备id
                int[] sensorId = new int[1];//传感器id
                byte[] pointId = new byte[32];//id
                byte[] szName = new byte[64];//名称
                byte[] szUnit = new byte[64];//测点值单位
                int[] nValueType = new int[1];
                int[] nValue = new int[1];
                double[] fValue = new double[1];
                byte[] szValue = new byte[256];
                byte[] stTime = new byte[32];
                byte[] szReserve = new byte[256];

                data.read(0, szDeviceId, 0, 31);
                data.read(32, sensorId, 0, 1);
                data.read(36, pointId, 0, 31);
                data.read(68, szName, 0, 63);
                data.read(132, szUnit, 0, 63);
                data.read(196, nValueType, 0, 1);
                data.read(200, nValue, 0, 1);
                data.read(208, fValue, 0, 1);
                data.read(216, szValue, 0, 255);
                data.read(472, stTime, 0, 31);
                data.read(504, szReserve, 0, 255);

                PointValuePairInfo pointValuePairInfo = new PointValuePairInfo();
                pointValuePairInfo.setSzDeviceId(new String(szDeviceId,Charset.forName("gbk")).trim());
                pointValuePairInfo.setSensorId(sensorId[0]);
                pointValuePairInfo.setPointId(new String(pointId,Charset.forName("gbk")).trim());
                pointValuePairInfo.setSzName(new String(szName, Charset.forName("gbk")).trim());
                pointValuePairInfo.setSzUnit(new String(szUnit,Charset.forName("gbk")).trim());
                pointValuePairInfo.setnValueType(nValueType[0]);
                pointValuePairInfo.setnValue(nValue[0]);
                pointValuePairInfo.setfValue(fValue[0]);
                pointValuePairInfo.setSzValue(new String(szValue,Charset.forName("gbk")).trim());
                pointValuePairInfo.setStTime(new String(stTime,Charset.forName("gbk")).trim());
                pointValuePairInfo.setSzReserve("");

                list3.add(pointValuePairInfo);

            }else if(type ==3){//设备状态变化通知
                byte[] szDeviceId = new byte[32];//设备id
                int[] status = new int[1] ;

                data.read(0, szDeviceId, 0, 31);
                data.read(32, status, 0, 1);

                DeviceStatus deviceStatus = new DeviceStatus();
                deviceStatus.setSzDeviceId(new String(szDeviceId).trim());
                deviceStatus.setStatus(status[0]);
                list4.add(deviceStatus);

            }else if(type ==4){//传感器状态变化通知
                byte[] szDeviceId = new byte[32];//设备id
                int[] sensorId = new int[1] ;//传感器id
                int[] status = new int[1] ;

                data.read(0, szDeviceId, 0, 31);
                data.read(32, sensorId, 0, 1);
                data.read(36, status, 0, 1);

                SensorStatus sensorStatus = new SensorStatus();
                sensorStatus.setStatus(status[0]);
                sensorStatus.setSzDeviceId(new String(szDeviceId).trim());
                sensorStatus.setSensorId(sensorId[0]);
                list5.add(sensorStatus);

            }else if(type ==5){//订阅的测点信息回调
                byte[] szDeviceId = new byte[32];//设备id
                int[] sensorId = new int[1];//传感器id
                byte[] pointId = new byte[32];//id
                byte[] szName = new byte[64];//名称
                byte[] szUnit = new byte[64];//测点值单位
                int[] nValueType = new int[1];
                int[] nValue = new int[1];
                double[] fValue = new double[1];
                byte[] szValue = new byte[256];
                byte[] stTime = new byte[32];
                byte[] szReserve = new byte[256];

                data.read(0, szDeviceId, 0, 31);
                data.read(32, sensorId, 0, 1);
                data.read(36, pointId, 0, 31);
                data.read(68, szName, 0, 63);
                data.read(132, szUnit, 0, 63);
                data.read(196, nValueType, 0, 1);
                data.read(200, nValue, 0, 1);
                data.read(208, fValue, 0, 1);
                data.read(216, szValue, 0, 255);
                data.read(472, stTime, 0, 31);
                data.read(504, szReserve, 0, 255);

                PointValuePairInfo pointValuePairInfo = new PointValuePairInfo();
                pointValuePairInfo.setSzDeviceId(new String(szDeviceId,Charset.forName("gbk")).trim());
                pointValuePairInfo.setSensorId(sensorId[0]);
                pointValuePairInfo.setPointId(new String(pointId,Charset.forName("gbk")).trim());
                pointValuePairInfo.setSzName(new String(szName, Charset.forName("gbk")).trim());
                pointValuePairInfo.setSzUnit(new String(szUnit,Charset.forName("gbk")).trim());
                pointValuePairInfo.setnValueType(nValueType[0]);
                pointValuePairInfo.setnValue(nValue[0]);
                pointValuePairInfo.setfValue(fValue[0]);
                pointValuePairInfo.setSzValue(new String(szValue,Charset.forName("gbk")).trim());
                pointValuePairInfo.setStTime(new String(stTime,Charset.forName("gbk")).trim());
                pointValuePairInfo.setSzReserve("");

                list7.add(pointValuePairInfo);

            }else if(type == 6){

                System.out.println("回调数据上来");
                byte[] szDeviceId = new byte[32];
                int[] lTransChannel = new int[1];
                int[] dwSize = new int[1];
                byte[] pBuffer = new byte[512];

                data.read(0, szDeviceId, 0, 31);
                data.read(32, lTransChannel, 0, 1);
                data.read(36, dwSize, 0, 1);
                data.read(40, pBuffer, 0, 512);

                MDKDLL_TransCommNotifyInfo mdkdll_transCommNotifyInfo = new MDKDLL_TransCommNotifyInfo();

                mdkdll_transCommNotifyInfo.setSzDeviceId(new String(szDeviceId,Charset.forName("gbk")).trim());
                mdkdll_transCommNotifyInfo.setlTransChannel(lTransChannel[0]);


                //注意demo上的例子只是16进制的转化，其他进制的还需自行处理
                StringBuffer a = new StringBuffer();
                for(int i=0;i<dwSize[0];i++)  {
                    System.out.println("返回数据的值"+ pBuffer[i]);
                    Integer x ;
                    if( pBuffer[i] <0) {
                        x = Integer.valueOf((Integer.valueOf(pBuffer[i]) + 256));
                    }else {
                        x = Integer.valueOf(pBuffer[i]);
                    }
                    //这里将返回的数据转化成16进制数据
                    a= a.append(x.toHexString(x)) ;
                }

                System.out.println("a的值:"+a.toString());
                mdkdll_transCommNotifyInfo.setpBuffer(a.toString());
                mdkdll_transCommNotifyInfo.setDwSize(dwSize[0]);

                list8.add(mdkdll_transCommNotifyInfo);

            }

        }
    }



    public static getSDK.MDKDLL_StatusCallback f = new getSDK.Data_Realize();
    public static getSDK.MDKDLL_AllTypeCallback g = new getSDK.Data_Realize_setCallBack();

}
