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
    lateinit var peopleAdapter:PeopleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recycler,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
    }
        private fun initRecyclerView(){
        val peopleModel=(activity as MainActivity).peopleModel

            peopleAdapter=PeopleAdapter(peopleModel?.people!!){
            if (it is PeopleDataClickEvent.PeopleDataItemClicked){
                var bundle=Bundle()
                bundle.putString("profileName",it.peopleData.name)
                bundle.putString("profilePicture",it.peopleData.image)
                findNavController().navigate(R.id.action_listFragment_to_profileFragment,bundle)
            }


        }
            recycler.adapter=peopleAdapter

    }

}
