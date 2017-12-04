package com.ucar.share;

public class FutureTest {
	
	public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        //这里会立即返回，因为获取的是FutureData，而非RealData
        Data data = client.request("name");
        //这里可以用一个sleep代替对其他业务逻辑的处理
        //在处理这些业务逻辑过程中，RealData也正在创建，从而充分了利用等待时间
        Thread.sleep(2000);
        //使用真实数据
        System.out.println("数据="+data.getResult());
    }
}

class Client {
    public Data request(final String string) {
        final FutureData futureData = new FutureData();
         
        new Thread(new Runnable() {
            @Override
            public void run() {
                //RealData的构建很慢，所以放在单独的线程中运行
                RealData realData = new RealData(string);
                futureData.setRealData(realData);
            }
        }).start();
         
        return futureData; //先直接返回FutureData
    }
}

interface Data {
    String getResult() throws InterruptedException;
}

//FutureData是Future模式的关键，它实际上是真实数据RealData的代理，封装了获取RealData的等待过程
class FutureData implements Data {
  RealData realData = null; //FutureData是RealData的封装
  boolean isReady = false;  //是否已经准备好
   
  public synchronized void setRealData(RealData realData) {
      if(isReady)
          return;
      this.realData = realData;
      isReady = true;
      notifyAll(); //RealData已经被注入到FutureData中了，通知getResult()方法
  }

  @Override
  public synchronized String getResult() throws InterruptedException {
      if(!isReady) {
          wait(); //一直等到RealData注入到FutureData中
      }
      return realData.getResult(); 
  }
}

class RealData implements Data {
    protected String data;
 
    public RealData(String data) {
        //利用sleep方法来表示RealData构造过程是非常缓慢的
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;
    }
 
    @Override
    public String getResult() {
        return data;
    }
}

