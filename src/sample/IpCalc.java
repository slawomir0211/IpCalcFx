package sample;

import org.apache.commons.net.util.SubnetUtils;
import org.apache.commons.net.util.SubnetUtils.SubnetInfo;

public class IpCalc {

    private SubnetUtils utils;
    private SubnetInfo info;
    private String ipAddress;
    private String netmask;
    private String network;
    private String addressMin;
    private String addressMax;
    private String broadcast;
    private Long addressCount;


    public IpCalc(String ipAddress){
        try{
            this.utils = new SubnetUtils(ipAddress);
            this.info = this.utils.getInfo();
            this.ipAddress = this.info.getAddress();
            this.netmask = this.info.getNetmask();
            this.network = this.info.getNetworkAddress();
            this.addressMin = this.info.getLowAddress();
            this.addressMax = this.info.getHighAddress();
            this.broadcast = this.info.getBroadcastAddress();
            this.addressCount = this.info.getAddressCountLong();
        }
        catch(IllegalArgumentException e){
            System.err.println("Bad IP Address format!");
        }
    }

    public String getIpAddress(){
        return this.ipAddress;
    }

    public String getNetmask(){
        return this.netmask;
    }

    public String getNetwork(){
        return this.network;
    }

    public String getAddressMin(){
        return this.addressMin;
    }

    public String getAddressMax(){
        return this.addressMax;
    }

    public String getBroadcast(){
        return this.broadcast;
    }

    public Long getAddressCount(){
        return this.addressCount;
    }



}
