package id.ac.polinema.idealbodyweight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import id.ac.polinema.idealbodyweight.fragment.AboutFragment;
import id.ac.polinema.idealbodyweight.fragment.BodyMassIndexFragment;
import id.ac.polinema.idealbodyweight.fragment.BrocaIndexFragment;
import id.ac.polinema.idealbodyweight.fragment.ResultFragment;
import id.ac.polinema.idealbodyweight.fragments.MenuFragment;

public class MainActivity extends AppCompatActivity implements
		MenuFragment.OnFragmentInteractionListener,
		BrocaIndexFragment.OnFragmentInteractionListener,
		BodyMassIndexFragment.OnFragmentInteractionListener,
		ResultFragment.OnFragmentInteractionListener {

	// Deklarasikan atribut Fragment di sini
	private AboutFragment aboutFragment;
	private MenuFragment menuFragment;
	private BrocaIndexFragment brocaIndexFragment;
	private BodyMassIndexFragment bodyMassIndexFragment;
	private ResultFragment resultFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		aboutFragment = AboutFragment.newInstance("D. Dena Indah Amalia");
		menuFragment = new MenuFragment();
		brocaIndexFragment = new BrocaIndexFragment();
		bodyMassIndexFragment = new BodyMassIndexFragment();
		resultFragment = new ResultFragment();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, menuFragment)
				.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return  true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		// TODO: Tambahkan penanganan menu di sini
		if(item.getItemId() == R.id.menu_about){
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, aboutFragment)
					.addToBackStack(null)
					.commit();
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBrocaIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, brocaIndexFragment)
				.commit();
	}

	@Override
	public void onBodyMassIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, bodyMassIndexFragment)
				.commit();
	}

	@Override
	public void onCalculateBrocaIndexClicked(float index) {
		resultFragment.setInformation(String.format("Your ideal weight is %.2f kg", index));
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, resultFragment)
				.commit();
	}

	@Override
	public void onTryAgainButtonClicked(String tag) {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, brocaIndexFragment)
				.commit();

		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, bodyMassIndexFragment)
				.commit();
	}

	@Override
	public void onCalculateBodyMassIndexClicked(float index) {
		resultFragment.setInformation(String.format("Your BMI is %.4f", index));
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, resultFragment)
				.commit();
	}
}