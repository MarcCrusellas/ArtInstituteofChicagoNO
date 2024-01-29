package com.example.artinstituteofchicagono.ui.fragment

import android.R
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.artinstituteofchicagono.data.room.small.SmallPaint
import com.example.artinstituteofchicagono.databinding.FragmentMainBinding
import com.example.artinstituteofchicagono.inter.OnClickListener
import com.example.artinstituteofchicagono.obj.vm.MainFVM
import com.example.artinstituteofchicagono.obj.vm.MianFVMFactory
import com.example.artinstituteofchicagono.ui.ArtAdapter
import com.example.artinstituteofchicagono.ui.SkelAdapter
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class MainFragment : Fragment(), OnClickListener, CoroutineScope {

    private val viewModel by viewModels<MainFVM> {
        MianFVMFactory(requireActivity().application, coroutineContext)
    }


    // private lateinit var viewModel: MainFVM


    private lateinit var artAdapter: ArtAdapter
    private var skAdapter: SkelAdapter = SkelAdapter(List(50) {
        '.'
    })
    private lateinit var linearLayoutManager: LayoutManager
    lateinit var bind: FragmentMainBinding


    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        setRetainInstance(true)
        setHasOptionsMenu(true)

        // retainInstance = true

        bind = FragmentMainBinding.inflate(layoutInflater)


        //  Toast.makeText(context, "ei $apiCalled", Toast.LENGTH_SHORT).show()





        return bind.root
    }


    override fun onResume() {
        super.onResume()

    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        bind.toolbar.title = "Brrr"
        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.setSupportActionBar(bind.toolbar)
        // val vm: MainFVM by viewModels { MianFVMFactory(requireActivity().application, coroutineContext) }

       //  viewModel = ViewModelProvider(this, MianFVMFactory(requireActivity().application, coroutineContext))[MainFVM::class.java]

        // var vm = ViewModelProvider(requireActivity(), MainFVM(requireContext(), coroutineContext))


        //  val room: PaintDatabase = PaintDatabase.invoke(requireContext())

        // val call = Repo().fetchData()

        linearLayoutManager = LinearLayoutManager(context)


        viewModel.data.observe(viewLifecycleOwner) {
            // adapter.submitList(it)

            Log.d("fff", it.toString())
            if (it != null) {

                // var artic = it.data
                GlobalScope.launch(Dispatchers.IO) {
                    val result = withContext(Dispatchers.IO) {

                        viewModel.database.paintDao().insertAll(it)

                    }


                    // Log.d("liiiiist",list.toString())
                    artAdapter = ArtAdapter(it, this@MainFragment)


                    withContext(Dispatchers.Main) {

                        bind.rvAll.apply {
                            setHasFixedSize(true) //Optimitza el rendiment de l’app
                            layoutManager = linearLayoutManager
                            adapter = artAdapter
                        }
                    }
                }
            } else {
                bind.rvAll.apply {
                    setHasFixedSize(true) //Optimitza el rendiment de l’app
                    layoutManager = linearLayoutManager
                    adapter = skAdapter
                    // Log.wtf("oooooooooooooooooooooooooooooooooooo", "djgdfhjxfgjdfsjsfdjkdfhkdghkfghk")
                }
            }
        }
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // TODO Add your menu entries here
        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.menuInflater.inflate(com.example.artinstituteofchicagono.R.menu.options, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onClick(paint: SmallPaint) {
        // TODO("Not yet implemented")
    }

}