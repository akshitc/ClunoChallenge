package com.akshit.clunochallenge.detail


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.akshit.clunochallenge.R
import com.akshit.clunochallenge.model.ClunoCarDetailResponse
import com.akshit.clunochallenge.network.RetrofitFactory
import kotlinx.android.synthetic.main.fragment_cluno_detail.*

/**
 * A [Fragment] subclass displaying the details of the car selected.
 *
 */
class ClunoDetailFragment : Fragment(), ClunoDetailView {

    lateinit var id: String
    lateinit var presenter: ClunoDetailPresenter

    companion object {
        fun newInstance(id: String): ClunoDetailFragment =
            ClunoDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ClunoDetailActivity.ID, id)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getString(ClunoDetailActivity.ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cluno_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ClunoDetailPresenter(this, RetrofitFactory.getRetrofitService())
        presenter.fetchDetails(id)
    }

    override fun showDetail(response: ClunoCarDetailResponse) {
        imagePager.adapter = ImagePagerAdapter(response.images)
        tabLayout.setupWithViewPager(imagePager, true)
        setUpDetailViews(response)
    }

    private fun setUpDetailViews(response: ClunoCarDetailResponse) {
        title.text = response.car.make + " " + response.car.model + " " + response.car.version
        price.text = getString(R.string.price, response.pricing.price, response.pricing.currencySymbol)
        doors.text = getString(R.string.doors_text, response.car.doors)
        drive.text = getString(R.string.drive_text, response.car.drive)
        fuelType.text = getString(R.string.fuel_type_text, response.car.fueltype)
        gearType.text = getString(R.string.gear_type_text, response.car.gearingType)
        color.text = getString(R.string.color_text, response.car.offerExtColor)
    }

    override fun showError() {
        Toast.makeText(context, R.string.error_text, Toast.LENGTH_LONG).show()
    }

}
