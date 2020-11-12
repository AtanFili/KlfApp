import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gsixacademy.android.klfapp.MainActivity
import com.gsixacademy.android.klfapp.R
import com.gsixacademy.android.klfapp.adapters.PeopleAdapter
import com.gsixacademy.android.klfapp.adapters.PeopleDataClickEvent
import com.gsixacademy.android.klfapp.data.PeopleModel
import kotlinx.android.synthetic.main.recycler.*

class ListFragment:Fragment(){

   var peopleList:PeopleModel?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
    }
        private fun initRecyclerView(){
        val peopleModel=(activity as MainActivity).peopleModel

        recycler.adapter=PeopleAdapter(peopleList?.people!!){
            if (it is PeopleDataClickEvent.PeopleDataItemClicked){
                val bundle=Bundle()
                bundle.putParcelable("peopleData",it.peopleData)
                findNavController().navigate(R.id.action_listFragment_to_profileFragment,bundle)
            }
        }

    }

}
