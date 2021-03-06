package com.sportsapp.volleyliga.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.sportsapp.volleyliga.R;
import com.sportsapp.volleyliga.models.MatchModel;
import com.sportsapp.volleyliga.models.TeamModel;
import com.sportsapp.volleyliga.presenters.TeamDetailMatchPresenter;
import com.sportsapp.volleyliga.utilities.BusProvider;
import com.sportsapp.volleyliga.utilities.busEvents.OpenMatchEvent;
import com.sportsapp.volleyliga.views.TeamDetailMatchListView;
import com.sportsapp.volleyliga.views.controllers.DividerItemDecoration;
import com.sportsapp.volleyliga.views.controllers.MatchListAdapter;

import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TeamMatchesView extends LinearLayout implements TeamDetailMatchListView {

    @Bind(R.id.recyclerView)
    public RecyclerView recyclerView;

    private MatchListAdapter adapter;

    private TeamModel team;
    private TeamDetailMatchPresenter presenter = new TeamDetailMatchPresenter();

    public TeamMatchesView(Context context) {
        super(context);

        setOrientation(VERTICAL);
        inflate(getContext(), R.layout.team_matches_view, this);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
        adapter = new MatchListAdapter(getContext());
        adapter.setMatchClickListener(match -> openMatch(match.federationMatchNumber));
        recyclerView.setAdapter(adapter);
    }

    public void setTeamModel(TeamModel team) {
        this.team = team;
        presenter.setTeam(team);
    }

    @Override
    public void openMatch(int federationMatchNumber) {
        BusProvider.getInstance().post(new OpenMatchEvent(federationMatchNumber));
    }

    @Override
    public void setMatches(List<MatchModel> data) {
        Collections.reverse(data);
        if (adapter != null) {
            adapter.setItems(data);
        }
    }
}
