package org.api.policyApi;

import java.io.Serializable;
import java.util.List;

//AllOf��
@SuppressWarnings("serial")
public class AllOf implements Serializable
{
	private List<Match> Match;
	private int MatchNum = 0;
	
	//��ȡ��ǩMatch�е�������Ϣ���б�洢
	public List<Match> getMatch()
	{
		return Match;
	}
	
	//���ñ�ǩMatch
	public void setMatch(List<Match> Match)
	{
		this.Match = Match;
	}
	
	//��ȡ��ǰAllOf��Match��ǩ������
	public int getMatchNum()
	{
		MatchNum = 0;
		for(Match match : Match)
			MatchNum++;
		return MatchNum;
	}
	
	//�ض���toString����
	@Override
	public String toString()
	{
		return "AllOf:[{" + Match +"}]";
	}
}
