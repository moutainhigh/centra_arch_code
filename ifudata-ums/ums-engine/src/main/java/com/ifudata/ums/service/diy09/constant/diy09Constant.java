package com.ifudata.ums.service.diy09.constant;

//import java.util.Properties;
//import com.ifudata.ums.constant.SysParamConstant;
//import com.ifudata.ums.util.PropertitesFiller;

public class diy09Constant {
	public static final String[][] DiyReceiveErrMsg = { { "MK:0255", "未确定的错误原因。" }, { "MK:0210", "MS错误。" },
			{ "MK:0209", "SIM中没有存储短消息的能力。" }, { "MK:0208", "SIM（Subscriber Identity Module）中存储短消息的空间满。" },
			{ "MK:0196", "短消息实体被禁止使用。" }, { "MK:0195", "扩展短消息实体地址无效。" }, { "MK:0194", "SMC系统错误。" },
			{ "MK:0193", "没有SMC指定（签约）。" }, { "MK:0192", "SMC忙。" }, { "MK:0176", "TPDU未被支持。" },
			{ "MK:0175", "未指定的TP-Command错误。" }, { "MK:0160", "操作不能被执行。" }, { "MK:0159", "未指定的TP-DCS错误。" },
			{ "MK:0145", "短消息类型未被支持。" }, { "MK:0144", "字母表数据编码方案DCS未被支持。" }, { "MK:0143", "未指定的TP-PID错误。" },
			{ "MK:0130", "不能替换短消息。" }, { "MK:0129", "短消息类型未被支持。" }, { "MK:0128", "电信业务设备交互未被支持。" },
			{ "MK:0079", "短消息超过主叫方的最大提交数，该短消息下发失败后，被删除。" }, { "MK:0078", "保护模式下删除消息。短消息处于正在下发的状态，SMC收到删除短消息的命令。" },
			{ "MK:0077", "SMC下发短消息时，接口缓冲区满。" }, { "MK:0069", "短消息只能从FCC（Flow Control Center）接口下发，但FCC接口不可用。" },
			{ "MK:0068", "SMC下发短消息给业务模块后，业务模块超时没有返回应答。短消息下发以后，接口没有给SMSC返回发送成功或失败信息。" }, { "MK:0067", "无效接口。" },
			{ "MK:0066", "因接口临时错误（已注销或未登录）导致短消息下发失败。" }, { "MK:0065", "GIW超时无应答。短消息下发以后，GIW模块没有给SMSC返回发送成功或失败信息。" },
			{ "MK:0064", "接口无下发短消息的权限。" }, { "MK:0063", "目的信令点或信令转接点SCCP（Signaling Connection Control Part）无法传送该消息。" },
			{ "MK:0062", "MTIServer因为流控下发短消息失败。" }, { "MK:0061", "MAPServer因为流控下发短消息失败。" }, { "MK:0058", "SGSN系统错误。" },
			{ "MK:0057",
					"MSC系统错误。一般是由于MSC的MAP层负荷过大，发生流控后返回的消息。另外，若交换机设置为每次发送或者接收短消息时都要鉴权，会发生鉴权无响应（因为无线信道掉话），而导致发生MSC返回“系统错误”给SMC的情况。" },
			{ "MK:0056", "HLR系统错误。一般是由于HLR的MAP层负荷过大，发生流控后返回的消息。" }, { "MK:0055", "SGSN拒绝。一般是由于SGSN的TCAP层负荷过大。" },
			{ "MK:0054", "SGSN（Serving GPRS Support Node）无应答。" }, { "MK:0053", "GIW模块拒绝。" },
			{ "MK:0052", "HLR拒绝。一般是由于HLR的TCAP层负荷过大，发生流控后回的消息。" }, { "MK:0051", "MSC拒绝。一般是由于MSC的TCAP层负荷过大，发生流控后返回的消息。" },
			{ "MK:0050", "GIW模块（信令网关）无应答。" }, { "MK:0049", "HLR无应答。" }, { "MK:0048", "MSC无应答。" },
			{ "MK:0046", "HLR版本协商错误。" }, { "MK:0045", "MAP协议版本错误。" }, { "MK:0041", "SMC发置位消息后，HLR无应答。" },
			{ "MK:0040", "SMC发路由查询请求后，HLR无应答。" }, { "MK:0037", "来自HLR的未知错误。" }, { "MK:0036", "来自MSC的未知错误。" },
			{ "MK:0035", "来自MSC的意外数据。来自MSC的消息包中某一个数据的值超过协议规定的范围。" },
			{ "MK:0034", "来自HLR的意外数据。来自HLR的消息包中某一个数据的值超过协议规定的范围。" }, { "MK:0033", "SMC没有取到足够的路由信息。" },
			{ "MK:0032", "INFORM_SC消息解码错误。HLR发送的消息包（INFORM_SC消息）中某一个数据的值超过协议规定的范围。" },
			{ "MK:0031", "MSC消息解码错误。MSC消息包中某一个数据的值超过协议规定的范围。" }, { "MK:0030", "HLR消息解码错误。HLR消息包中某一个数据的值超过协议规定的范围。" },
			{ "MK:0025", "过滤业务专用错误码。" }, { "MK:0024", "用户关机。下发短消息时，目的手机关机，导致该短消息下发失败。" },
			{ "MK:0023", "用户忙。下发短消息时，该目的手机正在接收或发送其它短消息，导致该短消息下发失败。" },
			{ "MK:0022", "非法手机。该手机的国际移动台标识（IMEI）非法。在维测台中的错误值为22。在ETSI GSM 0902协议中定义为12。" }, { "MK:0021", "未知SC。" },
			{ "MK:0020", "不正确SME地址。" }, { "MK:0019", "MS非SC用户。" }, { "MK:0018", "SC拥塞。" }, { "MK:0017", "手机内存满。" },
			{ "MK:0016", "MS未装备。在维测台中的错误值为16。在ETSI GSM 0902协议中定义为32。" },
			{ "MK:0015", "MS（Mobile Station）端错误。下发短消息时，手机在接收过程出现软件问题。例如，手机重启后，处理短消息部分软件没有初始化完成，此时无法正常处理短消息。" },
			{ "MK:0014", "意料外的数据。" }, { "MK:0013", "短消息中心下发短消息给网络侧时，有必选字段缺失。" }, { "MK:0012", "" },
			{ "MK:0011", "消息等待队列满。等待向该手机下发消息的SMC过多，导致HLR的MWD队列溢出。在维测台中的错误值为1。在ETSI GSM 0902协议中定义为33。" },
			{ "MK:0010", "SM发送失败。SMC下发短消息给DCS接口失败，返回SM发送失败。" }, { "MK:0009", "用户不在服务区MWDSET。" },
			{ "MK:0008", "用户不在服务区。用户当前所在地区信号不好，无法接收短消息。" },
			{ "MK:0007", "设备不支持。手机所在的HLR不支持“移动终结的短消息”。在维测台中的错误值为7。在ETSI GSM 0902协议中定义为21。" },
			{ "MK:0006", "闭合用户群拒绝。主叫用户没有呼叫群外用户的权限，却呼叫群外用户。在维测台中的错误值为6。在ETSI GSM 0902协议中定义为15。" },
			{ "MK:0005", "呼叫被禁止。该用户的短消息业务被禁止了。在维测台中的错误值为5。在ETSI GSM 0902协议中定义为13。" }, { "MK:0004", "电信业务不支持。" },
			{ "MK:0003", "非法用户。本次短消息发送过程中，用户鉴权未通过，可能的原因是MSC认为该手机的鉴权密码非法。在维测台中的错误值为3。在ETSI GSM 0902协议中定义为9。" },
			{ "MK:0002",
					"未定义用户。HLR指明了下发路由，但目的MSC（Mobile Switching Center）没有该MS的（Mobile Station）注册信息。可能的原因是MSC向HLR注册错误，或VLR（Visitor Location Register）中相关信息删除后没有通知HLR。在维测台中的错误值为2。在ETSI GSM 0902协议中定义为5。" },
			{ "MK:0001", "未知用户。在维测台中的错误值为1。在ETSI GSM 0902协议中定义为1。" }, { "MK:0000", "正常。" },
			{ "MC:0151", "SMSC没有给本网关回状态报告" }, { "MC:0001", "SMSC没有给本网关回状态报告" }, { "MB:1083", "反欺诈拒绝。" },
			{ "MB:1082", "查询CCM失败。" }, { "MB:1081", "取SRI路由失败。" }, { "MB:1080", "接口错误。" },
			{ "MB:1079", "SMC对短消息进行反漫游欺诈处理，发现该短消息为漫游欺诈短消息。SMC拒绝该短消息。" }, { "MB:1078", "所提交的消息无下发路由。" },
			{ "MB:1077", "被叫是注册用户黑名单。" }, { "MB:1076", "主叫是注册用户黑名单。" }, { "MB:1075", "对短消息的被叫用户进行虚拟短消息中心鉴权失败。" },
			{ "MB:1074", "对短消息的主叫用户进行虚拟短消息中心鉴权失败。" }, { "MB:1073", "对短消息的被叫号码进行帐号鉴权失败。" },
			{ "MB:1072", "对短消息的主叫号码进行帐号鉴权失败。" }, { "MB:1070", "流控错误，短消息中心拥塞。" }, { "MB:1069", "接口版本不匹配。" },
			{ "MB:1065", "UDH（User Data Header）错误，比如长度太长超过140字节（最大分包长度）。" },
			{ "MB:1064", "message_payload存在时UDL（User Data Length）必需为0，否则错误。" },
			{ "MB:1063", "message_payload可选参数的值太长。" }, { "MB:1062", "某个或者两个ports都非法（长度或值错误）。" },
			{ "MB:1061", "端口IE（Application Port Addressing）不能与两个ports共存。" },
			{ "MB:1060",
					"提交的消息携带的三个sars的值不满足约束，即：sar_total_segment_sequnum的值大于等于。ar_segment_seqnum的值 三个Sars中某些或全部TLV非法。" },
			{ "MB:1058", "分包消息不能再次分包。" }, { "MB:1057", "SMSC不支持的DCS或错误的DCS。" }, { "MB:1056", "无效的数据格式（UD数据内容错误）。" },
			{ "MB:1052", "PPS错误，暂未使用。" }, { "MB:1051", "计费用户不存在。" }, { "MB:1050", "计费用户为NP_OUT用户。" },
			{ "MB:1049", "被叫用户为NP_OUT用户。" }, { "MB:1048", "主叫用户为NP_OUT用户。" }, { "MB:1047", "计费用户不支持增值业务。" },
			{ "MB:1046", "计费用户金额不足。" }, { "MB:1045", "计费用户状态不正确。" }, { "MB:1044", "自定义的找不到路由错误。" },
			{ "MB:1043", "用户不存在或无效的用户。" },
			{ "MB:1042", "SMC内存中缓存的、要下发给被叫用户的短消息数超过了该用户的最大下发数。最大下发数指的是每个号码作为被叫号码时，能够缓存在SMC内存中的短消息的最大数。" },
			{ "MB:1041", "主叫用户提交的短消息数超过此用户的最大提交数。最大提交数指的是每个号码作为主叫号码时，能够缓存在SMC内存中的短消息的最大数目。" },
			{ "MB:1040", "被叫用户金额不足。" }, { "MB:1039", "主叫用户金额不足。" }, { "MB:1038", "被叫用户不支持增值业务。" },
			{ "MB:1037", "主叫用户不支持增值业务。" }, { "MB:1036", "被叫用户状态不正确。" }, { "MB:1035", "主叫用户状态不正确。" },
			{ "MB:1034", "PPS鉴权失败。可能的原因为：? PPS鉴权超时? SMSC发送鉴权消息失败? SMSC处理PPS消息出错? SCP返回其它错误" },
			{ "MB:1026", "License受限错误。SMC的相关运行参数（如MO速度、MT速度、短消息数、短消息实体数）已经达到了License的最大限制。" },
			{ "MB:1025", "无效的短消息中心。" }, { "MB:1024", "为此条短消息分配内存或其它资源失败。比如：创建短消息实体或短消息失败。" }, { "MB:0255", "不明错误。" },
			{ "MB:0254", "下发失败。" }, { "MB:0196", "无效的可选参数。" }, { "MB:0195", "必需的可选参数丢失。" }, { "MB:0194", "可选参数的长度错。" },
			{ "MB:0193", "命令字中含有被禁止的可选参数。" }, { "MB:0192", "PDU报文体中的可选部分出错。" }, { "MB:0103", "query_sm操作失败。" },
			{ "MB:0102", "ESME接收端拒绝消息出错。" }, { "MB:0101", "接收端永久性错误。" }, { "MB:0100", "接收端暂时错误。" },
			{ "MB:0099", "预定义短消息无效或不存在。SMC根据提交的短消息的sm_default_msg_id字段的值，找不到预定义短消息。" }, { "MB:0098", "短消息中指定的超时时间无效。" },
			{ "MB:0097", "短消息中指定的定时时间无效。" }, { "MB:0088", "短消息数超过了短消息中心的消息队列的最大限定。" }, { "MB:0085", "消息序号无效。" },
			{ "MB:0084", "replace_if_present_flag字段无效。" }, { "MB:0083", "System_type字段无效。" },
			{ "MB:0081", "无效的目的地址NPI。" }, { "MB:0080", "无效的目的地址TON。" }, { "MB:0073", "无效的源地址NPI。" },
			{ "MB:0072", "无效的源地址TON。" }, { "MB:0069", "submit_sm或者submit_multi失败。" }, { "MB:0068", "无法提交到分配表。" },
			{ "MB:0067", "ESM_CLASS的值无效。消息内容为空时，设置了消息头标志，则会收到该错误码。" }, { "MB:0066", "无效的替换请求。" },
			{ "MB:0064", "无效的目的地址列表。" }, { "MB:0052", "分配列表名错误。" }, { "MB:0051", "目标地址个数错误。" },
			{ "MB:0020", "短消息的服务类型非法。" }, { "MB:0019", "短消息队列已满。" }, { "MB:0018", "Replace短消息失败。" },
			{ "MB:0017", "Cancel短消息失败。" }, { "MB:0015", "系统ID错误。" }, { "MB:0014", "密码错误。" }, { "MB:0013", "绑定失败。" },
			{ "MB:0012", "短消息ID错误。" }, { "MB:0011", "短消息的目的地址错误。目的地址字段非法，比如长度大于协议中规定的最大长度21字节。" },
			{ "MB:0010", "短消息的源地址错误。源地址字段非法，比如长度大于协议中规定的最大长度21字节。" }, { "MB:0008", "系统错误。" },
			{ "MB:0007", "SMC系统错误。该错误一般出现于短消息中心发生自身资源紧张的临时性错误时，无法处理ESME提交的短消息。" }, { "MB:0006", "无效的优先标识。" },
			{ "MB:0005", "ESME已经绑定。" }, { "MB:0004", "命令与bind状态不一致。" },
			{ "MB:0003", "Command ID非法。消息的Command ID不是SMPP3.3协议中定义的Command ID值。" },
			{ "MB:0002", "命令长度错误。command_length的长度比消息头的长度小。" },
			{ "MB:0001", "消息长度错误。消息长度大于实际的short_message字段的长度或者message_payload可选参数的实际长度。" }, { "MB:0000", "成功。" },
			{ "MA:0054", "超时未接收到响应消息" }, { "MA:0053", "发送消息失败" }, { "MA:0052", "尚未成功登录" }, { "MA:0051", "尚未建立连接" },
			{ "ID:6153", "发送无应答失败" }, { "ID:6152", "发送失败" }, { "ID:6151", "等待应答过期" }, { "ID:6150", "在发送队列中过期" },
			{ "ID:1251", "SMWC 校验失败" }, { "ID:1250", "SMWC 校验失败" }, { "ID:1249", "SMWC 校验失败" },
			{ "ID:1248", "SMWC 校验失败" }, { "ID:1247", "SMWC 校验失败" }, { "ID:1246", "SMWC 校验失败" },
			{ "ID:1245", "SMWC 校验失败" }, { "ID:1244", "SMWC 校验失败" }, { "ID:1243", "SMWC 校验失败 " },
			{ "ID:1242", "SMMC校验失败" }, { "ID:1241", "SMMC校验失败" }, { "ID:1240", "SMMC校验失败" }, { "ID:0318", "关键字过滤失败" },
			{ "ID:0317", "操作/验证失败" }, { "ID:0315", "费率设置错" }, { "ID:0314", "实名替换错" }, { "ID:0313", "业务验证错" },
			{ "ID:0312", "优先级设置错" }, { "ID:0311", "流量控制错" }, { "ID:0310", "消息过期" }, { "ID:0143", "超过月最大发送MT数量" },
			{ "ID:0142", "超过日最大发送MT数量" }, { "ID:0141", "用户处在黑名单中" }, { "ID:0140", "用户不在白名单中" },
			{ "ID:0139", "下发时间段违法" }, { "ID:0138", "用户相关信息不存在" }, { "ID:0137", "伪码信息错误" }, { "ID:0136", "用户密码错误" },
			{ "ID:0135", "业务数据同步出错" }, { "ID:0134", "EC/SI数据同步出错" }, { "ID:0133", "用户数据同步出错" },
			{ "ID:0132", "相关信息不存在" }, { "ID:0131", "BOSS系统数据同步出错" }, { "ID:0129", "用户已经是梦网用户" },
			{ "ID:0128", "补款,冲正失败" }, { "ID:0127", "该用户没有足够的余额" }, { "ID:0126", "该用户不是神州行用户" },
			{ "ID:0125", "业务价格超出范围" }, { "ID:0124", "业务价格格式错误" }, { "ID:0123", "业务价格为负" }, { "ID:0122", "接收异常" },
			{ "ID:0121", "没有该类业务" }, { "ID:0120", "话单格式错误" }, { "ID:0119", "用户不能取消该业务" }, { "ID:0118", "用户已经签约了该业务" },
			{ "ID:0117", "该业务不能对该用户开放" }, { "ID:0116", "用户暂停签约该业务" }, { "ID:0115", "用户没有签约该业务" },
			{ "ID:0114", "EC/SI暂停服务" }, { "ID:0113", "EC/SI不存在" }, { "ID:0112", "EC/SI代码错误" }, { "ID:0111", "该业务尚未开通" },
			{ "ID:0111", "增加企业实名签名，消息内容超长。" }, { "ID:0110", "该服务种类尚未开通" }, { "ID:0109", "该服务种类不存在" },
			{ "ID:0108", "该业务暂停服务" }, { "ID:0107", "业务不存在" }, { "ID:0106", "服务代码错误" }, { "ID:0105", "业务代码错误" },
			{ "ID:0104", "用户没有使用该业务的权限" }, { "ID:0103", "用户欠费" }, { "ID:0102", "用户停机" }, { "ID:0101", "手机号码错误" },
			{ "ID:0100", "手机号码不存在" }, { "ID:0097", "此用户为接收者黑名单用户。" }, { "ID:0096", "此用户为发送者黑名单用户。" },
			{ "ID:0089", "到MDSP鉴权时，网关构造等待应答实体失败。" }, { "ID:0088", "等MDSP应答超时，网关重发鉴权消息。" },
			{ "ID:0087", "因MDSP流控，网关重发鉴权消息。" }, { "ID:0086", "因MDSP系统忙，且缓存满，网关重发鉴权消息。" },
			{ "ID:0085", "因MDSP系统忙，网关重发鉴权消息。" }, { "ID:0084", "网关向MDSP重发鉴权消息失败。" }, { "ID:0083", "短消息内容超过了接收侧的最大长度。" },
			{ "ID:0082", "循环路由。" }, { "ID:0081", "发送接收接口重复。" }, { "ID:0080", "CPCode错误。" }, { "ID:0079", "业务类型为空。" },
			{ "ID:0078", "SPID为空。" }, { "ID:0077", "超过最大Submit提交数。" }, { "ID:0076", "信息安全鉴权失败。" },
			{ "ID:0075", "送SCP鉴权等待应答超时。" }, { "ID:0074", "送SCP失败。" }, { "ID:0073", "等待应答超时。" }, { "ID:0072", "找不到路由。" },
			{ "ID:0071", "超过最大节点数。" }, { "ID:0070", "网络断连或目的设备关闭接口。" }, { "ID:0069", "此用户为黑名单用户。" },
			{ "ID:0068", "用户鉴权失败。" }, { "ID:0067", "接收服务目的地址鉴权失败。" }, { "ID:0066", "接收服务源地址鉴权失败。" },
			{ "ID:0065", "发送服务目的地址鉴权失败。" }, { "ID:0064", "发送服务源地址鉴权失败。" }, { "ID:0063", "不能识别的FeeType。" },
			{ "ID:0062", "定时发送时间已经过期。" }, { "ID:0061", "有效时间已经过期。" }, { "ID:0056", "用户鉴权时，用户状态不正常。" },
			{ "ID:0055", "等待状态报告超时。" }, { "ID:0054", "超时，未接收到响应消息。" }, { "ID:0053", "发送消息失败。" },
			{ "ID:0052", "尚未成功登录。" }, { "ID:0051", "尚未建立连接。" }, { "ID:0049", "超出单次最大群发量" }, { "ID:0048", "超出每日最大群发次数" },
			{ "ID:0047", "超出每月最大群发次数" }, { "ID:0046", "超出每日最大发送量" }, { "ID:0045", "超出每月最大发送量。" },
			{ "ID:0044", "消息发送不在有效时间段内。" }, { "ID:0043", "禁止向异网发送消息。" }, { "ID:0021", "MDSP用户鉴权模块，用户销户错误。" },
			{ "ID:0020", "MDSP用户鉴权模块，鉴权用户停机或欠费错误。" }, { "ID:0014", "禁止发送WAP PUSH消息。" }, { "ID:0013", "目的地址错误。" },
			{ "ID:0012", "计费地址错误。" }, { "ID:0011", "Msg_src错误。" }, { "ID:0010", "Src_ID错误。" },
			{ "ID:0009", "infoX-SMS GW不负责此计费号码。" }, { "ID:0008", "流量控制错误。" }, { "ID:0007", "业务代码错误。" },
			{ "ID:0006", "超过最大信息长度。" }, { "ID:0005", "资费代码错误。" }, { "ID:0004", "消息长度错误。或版本太高" },
			{ "ID:0003", "消息序列号重复。或认证错" }, { "ID:0002", "命令字错误，或非法源地址" }, { "ID:0001", "消息结构错误。" }, { "ID:0000", "正确" },
			{ "IA:0054", "超时未接收到响应消息" }, { "IA:0053", "发送消息失败" }, { "IA:0052", "尚未成功登录" }, { "IA:0051", "尚未建立连接" },
			{ "DB:0506", "数据库错误" }, { "DB:0505", "系统内部错误" }, { "DB:0504", "已超过LICENSE限定数量" },
			{ "DB:0503", "LICENSE不合法" }, { "DB:0502", "网络故障" }, { "DB:0501", "网络链接异常" }, { "DB:0500", "磁盘读写错误" },
			{ "DB:0156", "WAPPush消息格式检查错误" }, { "DB:0155", "不支持的承载模式" }, { "DB:0154", "MServer是断开状态" },
			{ "DB:0153", "信用度错误" }, { "DB:0152", "BOSS同步鉴权错误" }, { "DB:0151", "正文签名失败" }, { "DB:0150", "等M模块应答消息超时" },
			{ "DB:0147", "用户未点播该业务" }, { "DB:0146", "用户在SI黑名单中" }, { "DB:0145", "用户在EC黑名单中" },
			{ "DB:0144", "用户在全局黑名单中" }, { "DB:0143", "超过月最大发送MT数量" }, { "DB:0142", "超过日最大发送MT数量" },
			{ "DB:0141", "用户处在黑名单中" }, { "DB:0140", "用户不在白名单中" }, { "DB:0139", "下发时间段违法" }, { "DB:0138", "用户相关信息不存在" },
			{ "DB:0137", "伪码信息错误" }, { "DB:0136", "用户密码错误" }, { "DB:0135", "业务数据同步出错" }, { "DB:0134", "SP数据同步出错" },
			{ "DB:0133", "用户数据同步出错" }, { "DB:0132", "相关信息不存在" }, { "DB:0131", "BOSS系统数据同步出错" },
			{ "DB:0129", "用户已经是梦网用户" }, { "DB:0128", "补款,冲正失败" }, { "DB:0127", "该用户没有足够的余额" },
			{ "DB:0126", "该用户不是神州行用户" }, { "DB:0125", "业务价格超出范围" }, { "DB:0124", "业务价格格式错误" }, { "DB:0123", "业务价格为负" },
			{ "DB:0122", "接收异常" }, { "DB:0121", "没有该类业务" }, { "DB:0120", "话单格式错误" }, { "DB:0119", "用户不能取消该业务" },
			{ "DB:0118", "用户已经签约了该业务" }, { "DB:0117", "该业务不能对该用户开放" }, { "DB:0116", "用户暂停签约该业务" },
			{ "DB:0115", "用户没有签约该业务" }, { "DB:0114", "EC/SI暂停服务" }, { "DB:0113", "EC/SI不存在" },
			{ "DB:0112", "EC/SI代码错误" }, { "DB:0111", "该业务尚未开通" }, { "DB:0110", "该服务种类尚未开通" }, { "DB:0109", "该服务种类不存在" },
			{ "DB:0108", "该业务暂停服务" }, { "DB:0107", "业务不存在" }, { "DB:0106", "服务代码错误" }, { "DB:0105", "业务代码错误" },
			{ "DB:0104", "用户没有使用该业务的权限" }, { "DB:0103", "用户欠费" }, { "DB:0102", "用户停机" }, { "DB:0101", "手机号码错误" },
			{ "DB:0100", "手机号码不存在" }, { "DB:0010", "流量控制错" }, { "DB:0009", "超过最大信息长" }, { "DB:0008", "资费代码错" },
			{ "DB:0007", "消息长度错" }, { "DB:0006", "消息序号重复" }, { "DB:0005", "命令字错" }, { "DB:0004", "版本太高" },
			{ "DB:0003", "认证错" }, { "DB:0002", "非法源地址" }, { "DB:0001", "消息结构错" }, { "DB:0000", "正确" },
			{ "DA:0054", "超时未接收到响应消息" }, { "DA:0053", "发送消息失败" }, { "DA:0052", "尚未成功登录" }, { "DA:0051", "尚未建立连接" },
			{ "IC:0151", "SMSC没有给本网关回状态报告" }, { "IC:0001", "SMSC没有给本网关回状态报告" } };

	public static final String[][] DiySendErrMsg = { { "1", "下发缓冲池已满." }, { "2", "没有建立连接或连接断开" }, { "3", "流量超过设定值" },
			{ "4", "短信长度超出限制" }, { "5", "群发数量超出限制" }, { "7", "手机号为空" }, { "8", "手机号超长" },
			{ "78", "手机号为空或号码超长，没有正确的号码" } };

	// DELIVER 0上行 1报告回执
	public static final int C_CMPP_DELIVER = 0;
	public static final int C_CMPP_REPORT = 1;

	public static String SERVER_IP;
	public static String ACTIVETEST_INTERVAL;
	public static String USERNAME;
	public static String PASSWORD;
	public static String SERVER_PORT;
	public static String INTERSERVICEID;
	public static String LONGSMS_LEN;
	public static String DEFAULT_POOLNUM;
	public static String DEFAULT_SUBMITSLEEP;
	public static String DEFAULT_RECONN;
	public static String NORMALSMSLEN;
	public static String CONNLONGSMSSLEEP;
	public static String MASSSENDMAX;
	public static String SUBMIT_REP_LOG;

	public static String getFailedReceiveReasonString(String strErr) {
		if (strErr.length() >= 3) {
			for (int iloop = 0; iloop < 390; iloop++)
				if (diy09Constant.DiyReceiveErrMsg[iloop][0].equals(strErr)) {
					return diy09Constant.DiyReceiveErrMsg[iloop][1];
				}
		}

		return "未知错误";
	}

	public static String getFailedSendReasonString(String strErr) {
		if (strErr.length() >= 1) {
			for (int iloop = 0; iloop < 8; iloop++)
				if (diy09Constant.DiySendErrMsg[iloop][0].equals(strErr)) {
					return diy09Constant.DiySendErrMsg[iloop][1];
				}
		}

		return "未知错误";
	}

	static {
		// Properties props =
		// PropertitesFiller.fillPropertitesFromClassPath("diy09SMS.properties");
		// if(props != null){
		// SERVER_IP =
		// ((props.getProperty("SERVER_IP")!=null&&!"".equals(props.getProperty("SERVER_IP")))
		// ? props.getProperty("SERVER_IP") : "");
		// ACTIVETEST_INTERVAL =
		// ((props.getProperty("ACTIVETEST_INTERVAL")!=null&&!"".equals(props.getProperty("ACTIVETEST_INTERVAL")))
		// ? props.getProperty("ACTIVETEST_INTERVAL") : "");
		// USERNAME =
		// ((props.getProperty("USERNAME")!=null&&!"".equals(props.getProperty("USERNAME")))
		// ? props.getProperty("USERNAME") : "");
		// PASSWORD =
		// ((props.getProperty("PASSWORD")!=null&&!"".equals(props.getProperty("PASSWORD")))
		// ? props.getProperty("PASSWORD") : "");
		// SERVER_PORT =
		// ((props.getProperty("SERVER_PORT")!=null&&!"".equals(props.getProperty("SERVER_PORT")))
		// ? props.getProperty("SERVER_PORT") : "");
		// INTERSERVICEID =
		// ((props.getProperty("INTERSERVICEID")!=null&&!"".equals(props.getProperty("INTERSERVICEID")))
		// ? props.getProperty("INTERSERVICEID") : "");
		// LONGSMS_LEN =
		// ((props.getProperty("longSms_Len")!=null&&!"".equals(props.getProperty("longSms_Len")))
		// ? props.getProperty("longSms_Len") : "");
		// DEFAULT_POOLNUM =
		// ((props.getProperty("default_poolNum")!=null&&!"".equals(props.getProperty("default_poolNum")))
		// ? props.getProperty("default_poolNum") : "");
		// DEFAULT_SUBMITSLEEP =
		// ((props.getProperty("default_submitSleep")!=null&&!"".equals(props.getProperty("default_submitSleep")))
		// ? props.getProperty("default_submitSleep") : "");
		// DEFAULT_RECONN =
		// ((props.getProperty("default_reConn")!=null&&!"".equals(props.getProperty("default_reConn")))
		// ? props.getProperty("default_reConn") : "");
		// NORMALSMSLEN =
		// ((props.getProperty("normalSmsLen")!=null&&!"".equals(props.getProperty("normalSmsLen")))
		// ? props.getProperty("normalSmsLen") : "");
		// CONNLONGSMSSLEEP =
		// ((props.getProperty("connLongSmsSleep")!=null&&!"".equals(props.getProperty("connLongSmsSleep")))
		// ? props.getProperty("connLongSmsSleep") : "");
		// MASSSENDMAX =
		// ((props.getProperty("massSendMax")!=null&&!"".equals(props.getProperty("massSendMax")))
		// ? props.getProperty("massSendMax") : "");
		// SUBMIT_REP_LOG =
		// ((props.getProperty("submit_rep_log")!=null&&!"".equals(props.getProperty("submit_rep_log")))
		// ? props.getProperty("submit_rep_log") : "");
		// }
	}
}
