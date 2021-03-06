package com.lzb.rock.netty.entity;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lzb.rock.base.aop.annotation.RelEnum;
import com.lzb.rock.netty.enums.EventEnum;
import com.lzb.rock.netty.enums.PubTypeEnum;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 消息发送对象
 * 
 * @author lzb
 * @Date 2019年9月30日 下午6:00:01
 */
@Data
@Document(collection = "nettySendMsg")
public class NettySendMsg {

	@ApiModelProperty(value = "消息ID")
	@Id
	ObjectId msgId;

	@ApiModelProperty(value = "MQ消息ID")
	@Indexed
	String mqId;

	@ApiModelProperty(value = "消息所有者账号")
	String account;

	@ApiModelProperty(value = "发布类型")
	@RelEnum(PubTypeEnum.class)
	String pubType;

	@ApiModelProperty(value = "事件")
	@RelEnum(EventEnum.class)
	String event;

	@ApiModelProperty(value = "消息内容")
	String body;

	@ApiModelProperty(value = "发送者账号")
	String sendAccount;

	@ApiModelProperty(value = "接收消息账号")
	String receiveAccount;

	@ApiModelProperty(value = "超时时间,秒")
	Long overtime;

	@ApiModelProperty(value = "消息状态，0新建,1已下发,2已到达,3已超时")
	Integer msgState;

	@ApiModelProperty(value = "消息状态，0不需要回执,1需要回执")
	Integer receipt;

	@ApiModelProperty(value = "回执次数")
	Integer receiptCount;

	@ApiModelProperty(value = "发送次数")
	Integer sendCount;

	@ApiModelProperty(value = "创建时间")
	@CreatedDate
	Date createTime;

	@ApiModelProperty(value = "最后修改时间")
	@LastModifiedDate
	Date lastTime;

}
