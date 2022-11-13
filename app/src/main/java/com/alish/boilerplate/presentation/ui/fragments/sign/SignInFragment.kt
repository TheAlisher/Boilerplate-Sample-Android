package com.alish.boilerplate.presentation.ui.fragments.sign

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.R
import com.alish.boilerplate.databinding.FragmentSignInBinding
import com.alish.boilerplate.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : BaseFragment<SignInViewModel, FragmentSignInBinding>(
    R.layout.fragment_sign_in
) {

    override val viewModel: SignInViewModel by viewModels()
    override val binding by viewBinding(FragmentSignInBinding::bind)

    override fun setupListeners() = with(binding) {
        buttonSignIn.setOnClickListener {
            viewModel.signIn(
                inputEditSignInUsername.text.toString().trim(),
                inputEditSignInPassword.text.toString().trim()
            )
        }
    }

    override fun setupSubscribers() = with(binding) {
        viewModel.signInState.collectUIState(
            state = {
                it.setupViewVisibility(groupSignIn, loaderSignIn, true)
            },
            onError = {
                it.setupApiErrors(
                    inputLayoutSignInUsername,
                    inputLayoutSignInPassword
                )
            },
            onSuccess = {
                Toast.makeText(requireContext(), it.token, Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_signInFragment_to_homeFragment)
            }
        )
    }
}