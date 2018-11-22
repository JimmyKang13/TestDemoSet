package org.api.policyApi;

import java.io.Serializable;
import java.util.List;

//AllOf类
@SuppressWarnings("serial")
public class AllOf implements Serializable
{
	private List<Match> Match;
	private int MatchNum = 0;
	
	//获取标签Match中的所有信息，列表存储
	public List<Match> getMatch()
	{
		return Match;
	}
	
	//设置标签Match
	public void setMatch(List<Match> Match)
	{
		this.Match = Match;
	}
	
	//获取当前AllOf下Match标签的数量
	public int getMatchNum()
	{
		MatchNum = 0;
		for(Match match : Match)
			MatchNum++;
		return MatchNum;
	}
	
	//重定义toString函数
	@Override
	public String toString()
	{
		return "AllOf:[{" + Match +"}]";
	}
}
